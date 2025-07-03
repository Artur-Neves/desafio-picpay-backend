package br.com.neves.desafio_picpay.repository;

import br.com.neves.desafio_picpay.domain.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, UUID> {
}
