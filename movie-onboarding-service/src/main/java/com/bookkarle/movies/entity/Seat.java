package com.bookkarle.movies.entity;

import com.bookkarle.movies.entity.contants.Tier;
import jakarta.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;


    private Long auditoriumId;

    private String rowNumber;

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private Tier tier;
}
