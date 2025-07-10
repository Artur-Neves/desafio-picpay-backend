package br.com.neves.desafio_picpay.domain;

import br.com.neves.desafio_picpay.domain.dto.people.CreatePeopleDto;
import br.com.neves.desafio_picpay.domain.dto.people.UpdatePeopleDto;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    protected String name;
    @Column(unique = true)
    protected String cpf;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true, nullable = false)
    protected User user;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "people")
    @JoinColumn(unique = true, nullable = false)
    protected Account account;

    public String getCpf() {
        return cpf;
    }

    public People(String cpf, UUID id, String name, User user) {
        this.cpf = cpf;
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public People(CreatePeopleDto peopleDto, Role role){
        this.name = peopleDto.name();
        this.cpf = peopleDto.cpf();
        this.user = new User(peopleDto.userDto());
        this.user.setRole(role);
        this.account = new Account(this);
    }

    public People(UpdatePeopleDto peopleDto){
        this.name = peopleDto.name();
        this.cpf = peopleDto.cpf();
    }

    public People() {
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(id, people.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
