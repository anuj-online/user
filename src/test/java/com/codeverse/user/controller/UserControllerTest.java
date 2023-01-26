package com.codeverse.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UserControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule()).registerModule(new Jdk8Module());
    @Test
    void register() throws Exception{
        var userRequest = new User()
                .setBranch("Information technology")
                .setDob(LocalDate.of(1990, 1, 1))
                .setCollege("tit")
                .setLaptop(true)
                .setLaptopBrand("apple")
                .setEmail("anuj@anuj.com")
                .setPassword("dsasa")
                .setPhoneNumber("998898765");
        System.out.println(objectMapper.writeValueAsString(userRequest));
    }

    @Test
    void userEntities() {
    }
}