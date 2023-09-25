package com.bookkarle.booking.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ShowMetaData {
    @Id
    private Long showId;
    private long movieId;
    private long auditoriumId;
    private long theatrePartnerId;
    private long theatreId;

    private long externalShowId;

    private long externalMovieId;

    private long externalTheatreId;

    private long externalAuditoriumId;
}
