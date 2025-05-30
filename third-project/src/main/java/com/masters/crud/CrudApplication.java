package com.masters.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.masters.microservice.Microservice.class, args);
    }

}
