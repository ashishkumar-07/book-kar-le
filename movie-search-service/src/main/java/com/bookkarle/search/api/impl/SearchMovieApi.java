package com.bookkarle.search.api.impl;


import com.bookkarle.search.model.ActiveMovieAndTheatreList;
import com.bookkarle.search.model.MovieAvailableShowResponse;
import com.bookkarle.search.model.TheatreAvailableMovieShows;
import com.bookkarle.search.service.SearchMovieFacade;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class SearchMovieApi {

    private final SearchMovieFacade searchMovieFacade;
    @Operation(summary = "List All active(up to next 5 days) shows of a movie  based on city and language")
    @GetMapping("/{movieId}")
    private MovieAvailableShowResponse getShowsByMovieId(@RequestParam Long cityId, @RequestParam String language, @RequestParam Long movieId){
        return searchMovieFacade.fetchShowsByLanguageMovieAndCity(movieId,language,cityId);
    };

    @Operation(summary = "List All active(up to next 5 days) movies running in a theatre")
    @GetMapping("/theatres/{theatreId}")
    private TheatreAvailableMovieShows getShowsByTheatreId(@RequestParam Long cityId, @RequestParam Long theatreId){

        return searchMovieFacade.fetchShowsByTheatreAndCity(cityId, theatreId);
    }

    @GetMapping()
    @Operation(summary = "List all active(up to next 5 days) movies & theatres in a city")
    private ActiveMovieAndTheatreList getMovieAndTheatreList(@RequestParam Long cityId){

        return searchMovieFacade.getMovieAndTheatreList(cityId);
    }
}
