package com.bookkarle;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "SearchService",version = "0.1",
        description = "Provides APIs which helps selecting a movie show for booking",
        contact = @Contact(name = "Ashish K", email = "ashishkumar.sengar@gmail.com"),
        license =  @License(name = "MIT License")
))
public class MovieSearchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieSearchServiceApplication.class);


    }
}
