package br.com.neves.desafio_picpay.domain.dto.people;

import br.com.neves.desafio_picpay.domain.People;

import java.util.UUID;

public record ResponsePeopleDto(
        UUID id,
        String name,
        String email,
        String cpf
) {
    public ResponsePeopleDto(People people){
        this(people.getId(), people.getName(), people.getUser().getEmail(), people.getCpf());
    }
}
