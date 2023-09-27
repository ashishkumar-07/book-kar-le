package com.bookkarle.movies.api.contract;

import com.bookkarle.movies.entity.TheatrePartner;
import com.bookkarle.movies.model.PartnerOnboardingRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;



@Tag(

        name = "Partner Management API",
        description = "Following APIs are used to manage/onboard the theatre partners"
)
public interface TheatrePartnerApi {

    @Operation(summary = "This API onboards a partner")
    public TheatrePartner onboardPartner(PartnerOnboardingRequest partnerOnboardingRequest);

}
