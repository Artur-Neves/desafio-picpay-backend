package br.com.neves.desafio_picpay.service.validation.shopkeeper;

import br.com.neves.desafio_picpay.domain.Shopkeeper;
import br.com.neves.desafio_picpay.infra.exception.ShopkeeperException;
import br.com.neves.desafio_picpay.repository.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCnpj implements ValidateShopkeeper {
    @Autowired
    private ShopkeeperRepository repository;

    @Override
    public void validate(Shopkeeper shopkeeper) {
        if (repository.existsByCnpjAndIdNot(shopkeeper.getCnpj(), shopkeeper.getId())){
            throw new ShopkeeperException("Este CNPJ já esta sendo utilizado por outro Lojista");
        };
    }
}
