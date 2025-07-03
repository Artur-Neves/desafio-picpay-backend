package br.com.neves.desafio_picpay.repository;

import br.com.neves.desafio_picpay.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeopleRepository extends JpaRepository<People, UUID> {
    boolean existsByCpf(String cpf);

    boolean existsByCpfAndIdNot(String cpf, UUID uuid);

    boolean existsByUserEmailAndIdNot(String email, UUID id);
}
