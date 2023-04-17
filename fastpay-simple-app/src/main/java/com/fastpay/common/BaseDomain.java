package com.fastpay.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public abstract class BaseDomain implements Serializable {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public String toString() {
        try {
            return getClass().getSimpleName() + OBJECT_MAPPER.writeValueAsString( this );
        } catch ( JsonProcessingException e ) {
            throw new RuntimeException( e );
        }
    }
}
