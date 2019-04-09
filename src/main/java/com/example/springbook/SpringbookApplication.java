package com.example.springbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbookApplication.class, args);
	}

}

