package com.bookkarle.movies.model;

import com.bookkarle.movies.entity.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TheatreOnboardingRequest {

    @NotBlank
    private String theatreName;

    @Positive
    private long city_id;

    private String address;

    @NotBlank
    private String externalTheatreId;
}
