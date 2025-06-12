package com.masters.microservice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Microservice {

	public static void main(String[] args) {
		SpringApplication.run(Microservice.class, args);
	}

}
