package br.cefetmg.implicare.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(BusinessException ex) {
        super(ex);
    }

}
