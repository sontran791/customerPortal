package com.java.customerportal.exception.domain;

public class GifNotFoundException extends RuntimeException{
    public GifNotFoundException(Integer gifId) {
        super("Could not find gif for " + gifId);
    }
}
