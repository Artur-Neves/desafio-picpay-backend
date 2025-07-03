package br.com.neves.desafio_picpay.service;

import br.com.neves.desafio_picpay.domain.SimpleUser;
import br.com.neves.desafio_picpay.infra.exception.SimpleUserException;
import br.com.neves.desafio_picpay.repository.SimpleUserRepository;
import br.com.neves.desafio_picpay.service.validation.people.ValidatePeople;
import br.com.neves.desafio_picpay.service.validation.simple_user.ValidateSimpleUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SimpleUserService {
    @Autowired
    private SimpleUserRepository repository;

    @Autowired
    private List<ValidateSimpleUser> validateSimpleUser;

    public SimpleUser save(SimpleUser simpleUser){
        validateSimpleUser.forEach(d -> d.validate(simpleUser));
        return repository.save(simpleUser);
    }

    public Page<SimpleUser> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public SimpleUser findById(UUID uuid){
        return repository.findById(uuid).orElseThrow(()-> new SimpleUserException("Usuário comum não encontrado para este identificador"));
    }

    @Transactional
    public SimpleUser update(UUID uuid, SimpleUser simpleUserDto){
        SimpleUser simpleUser = this.findById(uuid);
        simpleUser.merge(simpleUserDto);
        return simpleUser;
    }

    public void delete(UUID uuid){
        repository.delete(this.findById(uuid));
    }

}
