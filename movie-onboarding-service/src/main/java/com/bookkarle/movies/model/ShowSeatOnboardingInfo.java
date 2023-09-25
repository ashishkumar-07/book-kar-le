package com.bookkarle.movies.model;

import com.bookkarle.movies.entity.contants.Tier;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ShowSeatOnboardingInfo {

    @NotBlank
    private String rowNumber;


    @NotBlank
    private String seatNumber;

    @NotBlank
    private SeatStatus seatStatus;

    private Tier tier;
}
