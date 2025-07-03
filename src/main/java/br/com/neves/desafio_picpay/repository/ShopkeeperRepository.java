package br.com.neves.desafio_picpay.repository;

import br.com.neves.desafio_picpay.domain.Shopkeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ShopkeeperRepository extends JpaRepository<Shopkeeper, UUID> {
    boolean existsByCnpjAndIdNot(String cnpj, UUID id);
}
