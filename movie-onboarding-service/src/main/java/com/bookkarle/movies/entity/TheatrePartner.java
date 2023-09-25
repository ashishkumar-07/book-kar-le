package com.bookkarle.movies.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TheatrePartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatrePartnerId;

    private String name;

    private String phoneNumber;

}
