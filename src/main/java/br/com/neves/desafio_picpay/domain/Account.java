package br.com.neves.desafio_picpay.domain;

import br.com.neves.desafio_picpay.infra.exception.AccountException;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne()
    @JoinColumn(name = "people_id")
    private People people;
    @ColumnDefault(value = "0.00")
    private BigDecimal amount;
    @Version
    private Integer version;

    public Account() {
    }

    public Account(People people) {
        this.people = people;
        this.amount = BigDecimal.ZERO;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void deposit(BigDecimal value){
        this.amount = this.amount.add(value);
    }

    public void withdraw(BigDecimal value) throws AccountException {
        if(this.amount.compareTo(value)<0) throw new AccountException("Você não pode sacar um valor maior do que possui em sua conta");
        this.amount = this.amount.subtract(value);
    }

    public Integer getVersion() {
        return version;
    }
}
