package com.bookkarle.movies.api.contract;

import com.bookkarle.movies.entity.Theatre;
import com.bookkarle.movies.model.TheatreOnboardingRequest;
import com.bookkarle.movies.model.TheatreResponse;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface TheatreApi {

    @Operation(summary = "This API onboards a theatre")
    public Theatre onboardTheatre(TheatreOnboardingRequest theatreOnboardingRequest);


}
