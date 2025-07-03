package br.com.neves.desafio_picpay.domain.dto.user;

import br.com.neves.desafio_picpay.domain.People;
import br.com.neves.desafio_picpay.domain.User;

import java.util.UUID;

public record ResponseUserDto(
        String email
) {
    public ResponseUserDto(User user){
        this(user.getEmail());
    }
}
