package br.com.neves.desafio_picpay.domain.dto.token;

import jakarta.validation.constraints.NotBlank;

public record SimpleTokenRequestDto(
        @NotBlank
        String refresh
) {
}
