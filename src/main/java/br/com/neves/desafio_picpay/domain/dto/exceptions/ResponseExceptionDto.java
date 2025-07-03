package br.com.neves.desafio_picpay.domain.dto.exceptions;

import java.time.LocalDateTime;

public record ResponseExceptionDto(
        int status,
        String type,
        String message,
        LocalDateTime timestamp
) {
    public <T extends Exception> ResponseExceptionDto(int status, T e){
        this(status, e.getClass().getSimpleName(), e.getMessage(), LocalDateTime.now());
    }
    public <T extends Exception> ResponseExceptionDto(int status, T e, String message){
        this(status, e.getClass().getSimpleName(), message, LocalDateTime.now());
    }
}
