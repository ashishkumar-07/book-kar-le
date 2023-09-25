package com.bookkarle.movies.model;

import com.bookkarle.movies.entity.Auditorium;
import com.bookkarle.movies.entity.contants.Tier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SeatOnboardingDetail {



    @NotBlank
    private String rowNumber;


    @NotBlank
    private String seatNumber;

    private Tier tier;
}
