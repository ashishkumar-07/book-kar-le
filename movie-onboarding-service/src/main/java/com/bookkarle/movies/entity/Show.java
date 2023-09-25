package com.bookkarle.movies.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "show")
@Data
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;
    private String externalShowId;

    private Long auditoriumId;

    private Long theaterId;

    private Long movieId;
    private String language;
    private LocalDate showDate;
    private ZonedDateTime showTime;

    private BigDecimal priceTierOne;

    private BigDecimal priceTierTwo;

    private BigDecimal priceTierThree;

}
