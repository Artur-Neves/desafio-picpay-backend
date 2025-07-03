package br.com.neves.desafio_picpay.domain.dto.user;

import br.com.neves.desafio_picpay.domain.Role;
import br.com.neves.desafio_picpay.utils.annotation.UniqueEmail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserDto(
        @NotBlank
        @Email
        @UniqueEmail
        String email,
        @Size(min = 8, max = 60, message = "O campo 'senha' deve conter entre 8 e 60 caractéres")
        @Pattern(regexp = "(?=.*?[a-z])(?=.*[A-Z]).{8,}", message = "A senha deve conter pelo menos uma letra maiuscula ou minúscula")
        @Pattern(regexp = "(?=.*\\d).{8,}", message = "A senha deve conter pelo menos um dígito")
        @Pattern(regexp = "(?=.*[@$!%*#?&]).{8,}", message = "A senha deve conter pelo menos um caracter especial")
        String password
) {
}
