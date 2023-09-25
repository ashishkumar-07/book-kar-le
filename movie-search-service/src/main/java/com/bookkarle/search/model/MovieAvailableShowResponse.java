package com.bookkarle.search.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
public class MovieAvailableShowResponse {
    List<MovieShow> movieShows;
}
