package br.com.neves.desafio_picpay.domain;

import br.com.neves.desafio_picpay.domain.dto.people.CreatePeopleDto;
import br.com.neves.desafio_picpay.domain.dto.people.UpdatePeopleDto;
import br.com.neves.desafio_picpay.domain.dto.shopkeeper.CreateShopkeeperDto;
import br.com.neves.desafio_picpay.domain.dto.shopkeeper.UpdateShopkeeperDto;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Shopkeeper extends People {
    private String cnpj;

    public Shopkeeper(String cpf, UUID id, String name, User user, String cnpj) {
        super(cpf, id, name, user);
        this.cnpj = cnpj;
    }

    public Shopkeeper(CreateShopkeeperDto shopkeeperDto) {
        super(shopkeeperDto.createPeopleDto(), Role.SHOPKEEPER);
        this.cnpj = shopkeeperDto.cnpj();
    }

    public Shopkeeper(UpdateShopkeeperDto shopkeeperDto) {
        super(shopkeeperDto.updatePeopleDto());
        this.cnpj = shopkeeperDto.cnpj();
    }

    public Shopkeeper(){
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void merge(Shopkeeper shopkeeperDto) {
        super.cpf = shopkeeperDto.getCpf();
        super.name = shopkeeperDto.getName();
        this.cnpj = shopkeeperDto.getCnpj();
    }
}
