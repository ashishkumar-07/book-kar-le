package com.bookkarle.offers.api.impl;


import com.bookkarle.offers.api.OfferApi;
import com.bookkarle.offers.service.OfferService;
import com.bookkarle.offers.model.OfferEligibilityRequest;
import com.bookkarle.offers.model.OfferEligibilityResponse;
import com.bookkarle.offers.model.OffersDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class OfferApiImpl implements OfferApi {
    private final OfferService offerService;
    @Override
    @Operation(summary = "check the eligibility of particular offer. If eligible then returns the offer amount")
    @PostMapping("/check-eligibility")
    public OfferEligibilityResponse checkOfferEligibility(@RequestBody OfferEligibilityRequest offerEligibility){
        return offerService.checkOfferEligibility(offerEligibility);
    }

    @Override
    @GetMapping
    @Operation(summary = "List all offer by city and theatre")
    public List<OffersDto> listActiveOffers(@RequestParam Long cityId, @RequestParam Long theatreId){

        return offerService.listActiveOffers(cityId,theatreId);
    }
}
