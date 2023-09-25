package com.bookkarle.search.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TheatreAvailableMovieShows {
    List<TheatreShow> theatreShows;
}
