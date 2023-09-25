package com.bookkarle.movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auditorium")
@Data

public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditorium_id")
    private Long auditoriumId;
    private String auditoriumName;
    private String externalAuditoriumId;
    private Long theatreId;
    private Integer seatingCapacity;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Auditorium auditorium = (Auditorium) object;

        return auditoriumId.equals(auditorium.auditoriumId);
    }

    @Override
    public int hashCode() {
        return auditoriumId.hashCode();
    }
}
