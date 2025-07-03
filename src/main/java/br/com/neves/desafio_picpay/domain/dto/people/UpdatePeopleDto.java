package br.com.neves.desafio_picpay.domain.dto.people;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record UpdatePeopleDto(
        @NotBlank
        @Size(min = 3, max = 255)
        String name,
        @NotBlank
        @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "número do registro de contribuinte individual brasileiro (CPF) com formato inválido")
        @CPF
        String cpf
) {
}
