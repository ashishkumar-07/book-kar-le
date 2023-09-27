package com.bookkarle.movies;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MovieManagement", description = "Onboarding and management service",
        version = "0.1",
        contact = @Contact(name = "Ashish K", email = "ashishkumar.sengar@gmail.com"),
        license =  @License(name = "MIT License")
))
@ComponentScan(value = "com.bookkarle")
public class MovieManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieManagementApplication.class, args);
    }

}