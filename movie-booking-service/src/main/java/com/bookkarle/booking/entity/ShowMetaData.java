package com.bookkarle.booking.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class ShowMetaData {
    @Id
    private Long showId;
    private UUID metaDataId;
    private Long cityId;
    private long movieId;
    private long auditoriumId;
    private long theatrePartnerId;
    private long theatreId;
    private String language;
    private long externalShowId;
    private long externalMovieId;
    private long externalTheatreId;
    private long externalAuditoriumId;
}
