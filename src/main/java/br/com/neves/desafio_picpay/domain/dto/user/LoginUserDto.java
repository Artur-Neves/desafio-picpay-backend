package br.com.neves.desafio_picpay.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginUserDto(
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 8, max = 60)
        String password
) {
}
