package com.conversor;

public class MonedaNegativaException extends RuntimeException {
    public MonedaNegativaException() {
        super();
    }

    public MonedaNegativaException(String message) {
        super(message);
    }
}
