package br.com.neves.desafio_picpay.domain.dto.simple_user;

import br.com.neves.desafio_picpay.domain.Role;
import br.com.neves.desafio_picpay.domain.dto.people.CreatePeopleDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSimpleUserDto(
        @JsonUnwrapped
        @Valid
        CreatePeopleDto createPeopleDto
) {
         public CreateSimpleUserDto(String name, String cpf, String email, String password){
                 this(new CreatePeopleDto(name, email, cpf, password));
         }
}
