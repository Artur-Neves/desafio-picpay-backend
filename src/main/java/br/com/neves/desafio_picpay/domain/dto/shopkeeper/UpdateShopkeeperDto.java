package br.com.neves.desafio_picpay.domain.dto.shopkeeper;

import br.com.neves.desafio_picpay.domain.dto.people.UpdatePeopleDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public record UpdateShopkeeperDto(
        @Valid
        @JsonUnwrapped
        UpdatePeopleDto updatePeopleDto,
        @NotBlank
        @CNPJ
        String cnpj
) {
        public UpdateShopkeeperDto(String name, String cpf, String cnpj){
                this(new UpdatePeopleDto(name, cpf), cnpj);
        }
}
