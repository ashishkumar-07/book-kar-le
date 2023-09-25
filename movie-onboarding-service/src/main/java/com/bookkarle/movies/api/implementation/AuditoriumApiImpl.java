package com.bookkarle.movies.api.implementation;

import com.bookkarle.movies.api.contract.AuditoriumApi;
import com.bookkarle.movies.entity.Auditorium;
import com.bookkarle.movies.model.AuditoriumOnboardingRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auditoriums")
@OpenAPIDefinition
public class AuditoriumApiImpl implements AuditoriumApi {

    @PostMapping
    @Override
    public Auditorium onboardAuditorium(AuditoriumOnboardingRequest auditoriumOnboardingRequest) {
        //TODO - Implementation
        return null;
    }
}
