package br.com.neves.desafio_picpay.service.validation.simple_user;

import br.com.neves.desafio_picpay.domain.Shopkeeper;
import br.com.neves.desafio_picpay.domain.SimpleUser;
import br.com.neves.desafio_picpay.service.validation.people.ValidatePeople;
import org.springframework.stereotype.Component;


public interface ValidateSimpleUser{
    void validate(SimpleUser simpleUser);
}
