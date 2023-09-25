package com.bookkarle.movies.api.contract;

import com.bookkarle.movies.entity.TheatrePartner;
import com.bookkarle.movies.model.PartnerOnboardingRequest;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;



public interface TheatrePartnerApi {

    @Operation(summary = "This API onboards a partner")
    public TheatrePartner onboardPartner(PartnerOnboardingRequest partnerOnboardingRequest);

}
