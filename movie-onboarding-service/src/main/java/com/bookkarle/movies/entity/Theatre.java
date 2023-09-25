package com.bookkarle.movies.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "theatre")
@Data
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_id")
    private Long theatreId;

    private String theatreName;

    private Long cityId;

    private String address;

    private Long theatrePartnerId;

    private String externalTheatrePartnerId;



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Theatre theatre = (Theatre) object;

        return theatreId.equals(theatre.theatreId);
    }

    @Override
    public int hashCode() {
        return theatreId.hashCode();
    }
}
