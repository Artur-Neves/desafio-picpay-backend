package br.com.neves.desafio_picpay.infra.config;

import br.com.neves.desafio_picpay.service.TokenService;
import br.com.neves.desafio_picpay.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FilterAuthentication extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenByRequest(request);
        if(token!=null){
            String subject = tokenService.verify(token);
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            UserDetails user  = userService.loadUserByUsername(subject);
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
            securityContext.setAuthentication(authentication);
            SecurityContextHolder.setContext(securityContext);
        }
        filterChain.doFilter(request, response);
    }

    private String getTokenByRequest(HttpServletRequest request) {
    String authorization = request.getHeader("authorization");
    return  authorization==null ? null : authorization.contains("Bearer ") ? authorization .replace("Bearer ", "") :authorization;
    }
}
