package com.bookkarle.movies.model;

import com.bookkarle.movies.entity.Theatre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class AuditoriumOnboardingRequest {

    @NotBlank
    private String auditoriumName;

    @NotBlank
    private String externalTheatreId;

    @Positive
    private int seatingCapacity;

    @NotEmpty
    List<SeatOnboardingDetail> seats;
}
