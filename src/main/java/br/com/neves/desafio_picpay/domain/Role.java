package br.com.neves.desafio_picpay.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("user", "Usuário comum"),
    SHOPKEEPER("shopkeeper", "Lojista");
    private final String role;
    private final String nameCompleted;

    Role(String role, String nameCompleted) {
        this.nameCompleted = nameCompleted;
        this.role = role;
    }

    public String nameCompleted() {
        return nameCompleted;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getAuthority() {
        return this.getRole();
    }
}
