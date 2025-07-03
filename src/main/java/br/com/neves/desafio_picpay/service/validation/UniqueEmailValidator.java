package br.com.neves.desafio_picpay.service.validation;

import br.com.neves.desafio_picpay.repository.UserRepository;
import br.com.neves.desafio_picpay.utils.annotation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !repository.existsByEmail(email);
    }
}
