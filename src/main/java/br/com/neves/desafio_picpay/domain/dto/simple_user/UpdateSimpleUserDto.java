package br.com.neves.desafio_picpay.domain.dto.simple_user;

import br.com.neves.desafio_picpay.domain.dto.people.UpdatePeopleDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateSimpleUserDto(
        @JsonUnwrapped
        @Valid
        UpdatePeopleDto updatePeopleDto
) {
        public UpdateSimpleUserDto(String name, String cpf, String cnpj){
                this(new UpdatePeopleDto(name, cpf));
        }
}
