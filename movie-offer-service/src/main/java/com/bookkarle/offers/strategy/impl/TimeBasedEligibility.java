package com.bookkarle.offers.strategy.impl;

import com.bookkarle.offers.entity.Offer;
import com.bookkarle.offers.model.OfferEligibilityRequest;
import com.bookkarle.offers.model.OfferEligibilityResponse;
import com.bookkarle.offers.strategy.OfferEligibilityStrategy;
import com.bookkarle.offers.util.OfferCalcUtil;

import java.math.BigDecimal;
import java.time.LocalTime;

public class TimeBasedEligibility implements OfferEligibilityStrategy {
    @Override
    public OfferEligibilityResponse calculate(OfferEligibilityRequest offerEligibilityRequest, Offer offer) {
        OfferEligibilityResponse offerEligibilityResponse = new OfferEligibilityResponse();
        LocalTime bookeShowTime = offerEligibilityRequest.getShowTime().toLocalTime();
        if(bookeShowTime.isAfter(offer.getApplicableAfterTime()) &&
                bookeShowTime.isBefore(offer.getApplicableBeforeTime()
          ))
        {
            offerEligibilityResponse.setEligible(true);
            offerEligibilityResponse.setOfferAmount(getAmount(offer, offerEligibilityRequest));

        }
        offerEligibilityResponse.setOfferId(offer.getOfferId());
        return offerEligibilityResponse;
    }

    private BigDecimal getAmount(Offer offer, OfferEligibilityRequest offerEligibilityRequest) {
        return switch (offer.getOfferType()){

            case PERCENTAGE -> OfferCalcUtil.getPercentageAmount(offerEligibilityRequest.getBookingAmountBeforeOffer(),offer.getOfferValue());
            case VALUE -> OfferCalcUtil.getFixedAmount(offerEligibilityRequest.getBookingAmountBeforeOffer(),offer.getOfferValue());
        };
    }
}
