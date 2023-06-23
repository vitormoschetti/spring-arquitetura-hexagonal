package br.com.hexagonal.application.shared;

public class DomainException extends RuntimeException {

    public DomainException(final String message) {
        super(message);
    }
}
