package com.devlpjruan.ecommercproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
@SpringBootApplication
public class EcommercprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercprojectApplication.class, args);
	}

}
