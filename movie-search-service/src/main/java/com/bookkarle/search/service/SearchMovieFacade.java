package com.bookkarle.search.service;

import com.bookkarle.search.model.ActiveMovieAndTheatreList;
import com.bookkarle.search.model.MovieAvailableShowResponse;
import com.bookkarle.search.model.TheatreAvailableMovieShows;

public interface SearchMovieFacade {
    MovieAvailableShowResponse fetchShowsByLanguageMovieAndCity(Long movieId, String language, Long cityId);

    TheatreAvailableMovieShows fetchShowsByTheatreAndCity(Long cityId, Long theatreId);

    ActiveMovieAndTheatreList getMovieAndTheatreList(Long cityId);
}
