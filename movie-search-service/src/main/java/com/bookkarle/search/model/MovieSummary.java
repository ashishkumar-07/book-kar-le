package com.bookkarle.search.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class MovieSummary {
    private String language;
    private List<MovieName> movieNames;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MovieName{
        private String movieId;
        private String movieName;
    }
}
