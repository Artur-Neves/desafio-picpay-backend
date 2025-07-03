package br.com.neves.desafio_picpay.repository;

import br.com.neves.desafio_picpay.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);

    Optional<UserDetails> findByEmail(String username);
}
