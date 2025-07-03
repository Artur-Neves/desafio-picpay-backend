package br.com.neves.desafio_picpay.domain.dto.shopkeeper;

import br.com.neves.desafio_picpay.domain.Shopkeeper;

import java.util.UUID;

public record ResponseShopkeeperDto(
        UUID id,
        String name,
        String email,
        String cpf,
        String cnpj
) {
    public ResponseShopkeeperDto (Shopkeeper shopkeeper){
        this(shopkeeper.getId(), shopkeeper.getName(), shopkeeper.getUser().getEmail(), shopkeeper.getCpf(), shopkeeper.getCnpj());
    }
}
