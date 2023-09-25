package com.bookkarle.movies.model;

import com.bookkarle.movies.entity.Auditorium;
import com.bookkarle.movies.entity.Movie;
import com.bookkarle.movies.entity.Theatre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class ShowOnboardingRequest {

    @Positive
    private long partnerAuditoriumId;

    @Positive
    private long externalTheaterId;

    @Positive
    private long externalMovieId;

    private ZonedDateTime showTime;

    @NotNull
    private BigDecimal priceTierOne;

    @NotNull
    private BigDecimal priceTierTwo;

    @NotNull
    private BigDecimal priceTierThree;

    private List<ShowSeatOnboardingInfo> showSeats;
}
