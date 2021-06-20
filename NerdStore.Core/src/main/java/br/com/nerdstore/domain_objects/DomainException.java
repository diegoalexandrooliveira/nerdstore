package br.com.nerdstore.domain_objects;

public class DomainException extends RuntimeException {

    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Exception innerException) {
        super(message, innerException);
    }
}
