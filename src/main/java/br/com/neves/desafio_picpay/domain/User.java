package br.com.neves.desafio_picpay.domain;

import br.com.neves.desafio_picpay.domain.dto.user.CreateUserDto;
import jakarta.persistence.*;
import org.hibernate.annotations.CollectionType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.*;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(CreateUserDto userDto){
        this.email = userDto.email();
        this.password = userDto.password();
        this.encodePassword();
    }
    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    public void encodePassword(){
        this.password =  BCrypt.hashpw(this.password, BCrypt.gensalt());
    }
}
