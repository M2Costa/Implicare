package br.cefetmg.implicare.exception;

public class PersistenceException extends RuntimeException {

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(PersistenceException ex) {
        super(ex);
    }
}
