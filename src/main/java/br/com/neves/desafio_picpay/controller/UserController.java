package br.com.neves.desafio_picpay.controller;

import br.com.neves.desafio_picpay.domain.User;
import br.com.neves.desafio_picpay.domain.dto.token.SimpleTokenResponseDto;
import br.com.neves.desafio_picpay.domain.dto.user.LoginUserDto;
import br.com.neves.desafio_picpay.service.TokenService;
import br.com.neves.desafio_picpay.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/login")
    public ResponseEntity<SimpleTokenResponseDto> login (@RequestBody @Valid LoginUserDto userDto){
        var usernameToken = new UsernamePasswordAuthenticationToken(userDto.email(), userDto.password());
        Authentication authentication = manager.authenticate(usernameToken);
        return ResponseEntity.ok(tokenService.createTokens((User) authentication.getPrincipal()));
    }
}
