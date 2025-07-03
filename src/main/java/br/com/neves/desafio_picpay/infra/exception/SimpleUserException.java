package br.com.neves.desafio_picpay.infra.exception;

public class SimpleUserException extends RuntimeException {
    public SimpleUserException(String message) {
        super(message);
    }
}
