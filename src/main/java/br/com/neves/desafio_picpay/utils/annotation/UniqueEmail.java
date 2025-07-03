package br.com.neves.desafio_picpay.utils.annotation;

import br.com.neves.desafio_picpay.service.validation.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    String message() default "Já existe um usuário cadastrado com este email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
