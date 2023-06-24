package br.com.hexagonal.domain.shared.exception;

public class DomainException extends RuntimeException {

    public DomainException(final String message) {
        super(message);
    }
}
