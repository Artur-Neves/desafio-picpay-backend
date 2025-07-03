package br.com.neves.desafio_picpay.service;

import br.com.neves.desafio_picpay.domain.User;
import br.com.neves.desafio_picpay.domain.dto.token.SimpleTokenResponseDto;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;


@Service
public class TokenService {
    @Value("${br.com.neves.desafio_picpay.algorithm.token}")
    private String SECRET_ALGORITHM_TOKEN;
    @Value("${br.com.neves.desafio_picpay.algorithm.refresh.token}")
    private String SECRET_ALGORITHM_REFRESH_TOKEN;
    private int HOUR_TOKEN = 2;
    private int HOUR_REFRESH_TOKEN = 24 * 30;


    public String createToken(User user){
            Algorithm algorithm = Algorithm.HMAC256(SECRET_ALGORITHM_TOKEN);
           return JWT.create()
                    .withIssuer("Artur Neves")
                    .withSubject(user.getEmail())
                    .withClaim("role", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .withIssuedAt(Instant.now())
                    .withExpiresAt(getExpiredDate(HOUR_TOKEN))
                    .sign(algorithm);
    }

    public String createRefreshToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_ALGORITHM_REFRESH_TOKEN);
        return JWT.create()
                .withIssuer("Artur Neves")
                .withSubject(user.getEmail())
                .withClaim("role",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .withIssuedAt(Instant.now())
                .withExpiresAt(getExpiredDate(HOUR_REFRESH_TOKEN))
                .sign(algorithm);
    }

    public SimpleTokenResponseDto createTokens(User user){
        return new SimpleTokenResponseDto(createToken(user), createRefreshToken(user));
    }



    private Instant getExpiredDate(int hours){
        return LocalDateTime.now().plusHours(hours).atZone(ZoneId.of( "America/Bahia")).toInstant();
    }


}
