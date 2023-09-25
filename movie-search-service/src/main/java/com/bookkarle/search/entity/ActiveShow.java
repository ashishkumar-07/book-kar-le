package com.bookkarle.search.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Data
public class ActiveShow {
    @Id
    private Long showId;

    private Long auditoriumId;

    private String auditoriumName ;

    private Long theaterId;

    private Long cityId;

    private String theaterName;

    private Long movieId;
    private String movieName;

    private String showLanguage;
    private LocalDate showDate;
    private ZonedDateTime showTime;

    private BigDecimal priceTierOne;

    private BigDecimal priceTierTwo;

    private BigDecimal priceTierThree;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ActiveShow that = (ActiveShow) object;
        return Objects.equals(showId, that.showId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showId);
    }
}
