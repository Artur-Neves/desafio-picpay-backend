package br.com.neves.desafio_picpay.domain.dto.simple_user;

import br.com.neves.desafio_picpay.domain.Shopkeeper;
import br.com.neves.desafio_picpay.domain.SimpleUser;

import java.util.UUID;

public record ResponseSimpleUserDto(
        UUID id,
        String name,
        String email,
        String cpf
) {
    public ResponseSimpleUserDto(SimpleUser simpleUser){
        this(simpleUser.getId(), simpleUser.getName(), simpleUser.getUser().getEmail(), simpleUser.getCpf());
    }
}
