package com.bookkarle.offers.strategy;

import com.bookkarle.offers.entity.Offer;
import com.bookkarle.offers.model.OfferEligibilityRequest;
import com.bookkarle.offers.model.OfferEligibilityResponse;

public interface OfferEligibilityStrategy {

    public OfferEligibilityResponse calculate(OfferEligibilityRequest offerEligibilityRequest, Offer offer);
}
