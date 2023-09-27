package com.bookkarle.movies.api.contract;

import com.bookkarle.movies.entity.Movie;
import com.bookkarle.movies.entity.Theatre;
import com.bookkarle.movies.model.MovieOnboardingRequest;
import com.bookkarle.movies.model.TheatreOnboardingRequest;
import com.bookkarle.movies.model.TheatreResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "Movie Management API",
        description = "Following APIs are used to manage/onboard the movies"
)
public interface MovieApi {

    @Operation(summary = "API is for onboarding a movie")
    public Movie onboardMovie(MovieOnboardingRequest theatreOnboardingRequest);



}
