package br.com.neves.desafio_picpay.service.validation.people;

import br.com.neves.desafio_picpay.domain.People;
import br.com.neves.desafio_picpay.service.validation.shopkeeper.ValidateShopkeeper;
import br.com.neves.desafio_picpay.service.validation.simple_user.ValidateSimpleUser;
import org.springframework.stereotype.Component;

@Component
public interface ValidatePeople extends ValidateSimpleUser, ValidateShopkeeper {

}
