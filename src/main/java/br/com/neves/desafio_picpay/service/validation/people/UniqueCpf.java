package br.com.neves.desafio_picpay.service.validation.people;

import br.com.neves.desafio_picpay.domain.Shopkeeper;
import br.com.neves.desafio_picpay.domain.SimpleUser;
import br.com.neves.desafio_picpay.infra.exception.PeopleException;
import br.com.neves.desafio_picpay.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCpf implements ValidatePeople {
    @Autowired
    private PeopleRepository repository;

    @Override
    public void validate(Shopkeeper shopkeeper) {
        if (repository.existsByCpfAndIdNot(shopkeeper.getCpf(), shopkeeper.getId()))
            throw new PeopleException("Este número de CPF já esta sendo utilizado por outra pessoa");
    }

    @Override
    public void validate(SimpleUser shopkeeper) {
        if (repository.existsByCpfAndIdNot(shopkeeper.getCpf(), shopkeeper.getId()))
            throw new PeopleException("Este número de CPF já esta sendo utilizado por outra pessoa");
    }
}
