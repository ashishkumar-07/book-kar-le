package com.bookkarle.movies.api.contract;

import com.bookkarle.movies.entity.Auditorium;
import com.bookkarle.movies.model.AuditoriumOnboardingRequest;
import io.swagger.v3.oas.annotations.Operation;



public interface AuditoriumApi {

    @Operation(summary = "Onboarding an auditorium")
    public Auditorium onboardAuditorium(AuditoriumOnboardingRequest auditoriumOnboardingRequest);
}
