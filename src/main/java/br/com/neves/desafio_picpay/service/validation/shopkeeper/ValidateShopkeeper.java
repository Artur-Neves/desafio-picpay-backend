package br.com.neves.desafio_picpay.service.validation.shopkeeper;

import br.com.neves.desafio_picpay.domain.Shopkeeper;
import br.com.neves.desafio_picpay.service.validation.people.ValidatePeople;
import org.springframework.stereotype.Component;

@Component
public interface ValidateShopkeeper {
    void validate(Shopkeeper shopkeeper);
}
