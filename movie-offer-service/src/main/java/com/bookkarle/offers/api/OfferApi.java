package com.bookkarle.offers.api;

import com.bookkarle.offers.model.OfferEligibilityRequest;
import com.bookkarle.offers.model.OfferEligibilityResponse;
import com.bookkarle.offers.model.OffersDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(

        name = "Movie Offer APIs",
        description = "Following APIs are used to display the list of offer and calculate the eligibility of particular offer"
)
public interface OfferApi {
    @Operation(summary = "check the eligibility of particular offer. If eligible then returns the offer amount")
    @PostMapping("/check-eligibility")
    OfferEligibilityResponse checkOfferEligibility(@RequestBody OfferEligibilityRequest offerEligibility);

    @GetMapping
    @Operation(summary = "List all offer by city and theatre")
    List<OffersDto> listActiveOffers(@RequestParam Long cityId, @RequestParam Long theatreId);
}
