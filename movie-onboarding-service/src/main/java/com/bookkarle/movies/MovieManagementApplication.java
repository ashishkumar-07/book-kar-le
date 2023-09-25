package com.bookkarle.movies;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MovieManagement", description = "Onboarding and management service"))
public class MovieManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieManagementApplication.class, args);
    }

}