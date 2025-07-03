package br.com.neves.desafio_picpay.domain.dto.shopkeeper;

import br.com.neves.desafio_picpay.domain.Role;
import br.com.neves.desafio_picpay.domain.dto.people.CreatePeopleDto;
import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

public record CreateShopkeeperDto(
        @Valid
        @JsonUnwrapped
        CreatePeopleDto createPeopleDto,
        @NotBlank
        @CNPJ
        String cnpj
) {
         public CreateShopkeeperDto (String name, String cpf, String email, String password, String cnpj){

                 this(new CreatePeopleDto(name, email, cpf, password), cnpj);

         }
}
