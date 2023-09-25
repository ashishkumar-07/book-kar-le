package com.bookkarle.search.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActiveMovieAndTheatreList {
    List<TheatreSummary> theatres;
    List<MovieSummary> movies;
}
