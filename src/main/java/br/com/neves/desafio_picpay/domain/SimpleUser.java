package br.com.neves.desafio_picpay.domain;

import br.com.neves.desafio_picpay.domain.dto.people.CreatePeopleDto;
import br.com.neves.desafio_picpay.domain.dto.people.UpdatePeopleDto;
import br.com.neves.desafio_picpay.domain.dto.simple_user.CreateSimpleUserDto;
import br.com.neves.desafio_picpay.domain.dto.simple_user.UpdateSimpleUserDto;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class SimpleUser extends People {
    public SimpleUser() {
    }

    public SimpleUser(String cpf, UUID id, String name, User user) {
        super(cpf, id, name, user);
    }

    public SimpleUser(CreateSimpleUserDto simpleUserDto) {
        super(simpleUserDto.createPeopleDto(), Role.USER);
    }

    public SimpleUser(UpdateSimpleUserDto simpleUserDto) {
        super(simpleUserDto.updatePeopleDto());
    }

    public void merge(SimpleUser simpleUserDto) {
        super.cpf = simpleUserDto.getCpf();
        super.name = simpleUserDto.getName();
    }
}
