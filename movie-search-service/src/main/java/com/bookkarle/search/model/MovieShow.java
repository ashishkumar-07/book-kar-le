package com.bookkarle.search.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieShow {

    LocalDate date;
    List<Show> shows;

}
