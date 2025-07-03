package br.com.neves.desafio_picpay.domain.dto.exceptions;

import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public record ErrorValidationResponseDto(
        int status,
        String type,
        String message,
        List<FieldErrorDto> errors,
        LocalDateTime timestamp
) {
    public ErrorValidationResponseDto (MethodArgumentNotValidException exception){
        this(400,
                exception.getClass().getSimpleName(),
                Objects.requireNonNull(exception.getFieldError()).getDefaultMessage(),
                exception.getFieldErrors().stream().map(FieldErrorDto::new).toList(),
                LocalDateTime.now());
    }
}
