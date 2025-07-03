package br.com.neves.desafio_picpay.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserDto(
        @NotBlank
        @Email
        String email
) {
}
