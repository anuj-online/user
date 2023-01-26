package com.codeverse.user.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class ObjectMapperFactory {
    private static final ObjectMapper objectMapper;
   static  {
        objectMapper = new ObjectMapper()
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new Jdk8Module());
    }

    public static ObjectMapper getInstancce(){
        return objectMapper;
    }
}