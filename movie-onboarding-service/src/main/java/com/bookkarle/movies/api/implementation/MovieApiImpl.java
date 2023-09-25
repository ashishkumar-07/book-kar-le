package com.bookkarle.movies.api.implementation;

import com.bookkarle.movies.api.contract.MovieApi;
import com.bookkarle.movies.entity.Movie;
import com.bookkarle.movies.model.MovieOnboardingRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/movies")
public class MovieApiImpl implements MovieApi {

    @PostMapping
    @Override
    public Movie onboardMovie(MovieOnboardingRequest theatreOnboardingRequest) {
        return null; //TODO
    }


}
