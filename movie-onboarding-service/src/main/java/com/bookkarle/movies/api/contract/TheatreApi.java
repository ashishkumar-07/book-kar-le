package com.bookkarle.movies.api.contract;

import com.bookkarle.movies.entity.Theatre;
import com.bookkarle.movies.model.TheatreOnboardingRequest;
import com.bookkarle.movies.model.TheatreResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(

        name = "Theatre Management API",
        description = "Following APIs are used to manage/onboard the theatres"
)
public interface TheatreApi {

    @Operation(summary = "This API onboards a theatre")
    public Theatre onboardTheatre(TheatreOnboardingRequest theatreOnboardingRequest);


}
