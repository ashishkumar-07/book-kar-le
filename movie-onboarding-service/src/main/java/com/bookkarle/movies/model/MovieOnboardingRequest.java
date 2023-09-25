package com.bookkarle.movies.model;

import com.bookkarle.movies.entity.contants.Genre;
import com.bookkarle.movies.entity.contants.Language;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieOnboardingRequest {
    @NotBlank
    private String externalMovieId;
    @NotBlank
    private String movieName;
    @NotBlank
    private Language language;

    @Positive
    private int durationInMinutes;

    private LocalDate releaseDate;

    private Genre genre;
}
