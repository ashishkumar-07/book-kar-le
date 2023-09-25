package com.bookkarle.movies.entity;

import com.bookkarle.movies.entity.contants.Genre;
import com.bookkarle.movies.entity.contants.Language;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String externalMovieId;

    private String movieName;


    private String[] language;

    private int duration;

    private Boolean active;

    private LocalDate releaseDate;

    private String trailerfUrl;

    private String[] imageUrl;

    @Enumerated(EnumType.STRING)
    private Genre genre;

}