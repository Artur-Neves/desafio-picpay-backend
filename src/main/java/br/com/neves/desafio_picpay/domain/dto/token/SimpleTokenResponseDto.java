package br.com.neves.desafio_picpay.domain.dto.token;

public record SimpleTokenResponseDto(
        String token,
        String refresh
) {
}
