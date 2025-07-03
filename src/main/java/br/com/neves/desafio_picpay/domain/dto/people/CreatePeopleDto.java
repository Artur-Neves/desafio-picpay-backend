package br.com.neves.desafio_picpay.domain.dto.people;

import br.com.neves.desafio_picpay.domain.Role;
import br.com.neves.desafio_picpay.domain.dto.user.CreateUserDto;
import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record CreatePeopleDto(
        @NotBlank
        @Size(min = 3, max = 255)
        String name,
        @NotBlank
        @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "número do registro de contribuinte individual brasileiro (CPF) com formato inválido")
        @CPF
        String cpf,
        @JsonUnwrapped
        @Valid
        CreateUserDto userDto
) {
        public CreatePeopleDto(String name, String email, String cpf, String password){
                this(name, cpf, new CreateUserDto(email, password));
        }
}
