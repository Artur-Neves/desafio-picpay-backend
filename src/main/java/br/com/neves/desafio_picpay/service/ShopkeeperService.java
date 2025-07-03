package br.com.neves.desafio_picpay.service;

import br.com.neves.desafio_picpay.domain.Shopkeeper;
import br.com.neves.desafio_picpay.infra.exception.ShopkeeperException;
import br.com.neves.desafio_picpay.repository.ShopkeeperRepository;
import br.com.neves.desafio_picpay.service.validation.people.ValidatePeople;
import br.com.neves.desafio_picpay.service.validation.shopkeeper.ValidateShopkeeper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShopkeeperService {
    @Autowired
    private ShopkeeperRepository repository;

    @Autowired
    private List<ValidateShopkeeper> validateShopkeepers;

    public Shopkeeper save(Shopkeeper shopkeeper){
        validateShopkeepers.forEach(d -> d.validate(shopkeeper));
        return repository.save(shopkeeper);
    }

    public Page<Shopkeeper> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Shopkeeper findById(UUID uuid){
        return repository.findById(uuid).orElseThrow(()-> new ShopkeeperException("Lojista não encontrado para este identificador"));
    }

    @Transactional
    public Shopkeeper update(UUID uuid, Shopkeeper shopkeeperDto){
        Shopkeeper shopkeeper = this.findById(uuid);
        shopkeeperDto.setId(uuid);
        validateShopkeepers.forEach(d -> d.validate(shopkeeperDto));
        shopkeeper.merge(shopkeeperDto);
        return shopkeeper;
    }

    public void delete(UUID uuid){
        repository.delete(this.findById(uuid));
    }


}
