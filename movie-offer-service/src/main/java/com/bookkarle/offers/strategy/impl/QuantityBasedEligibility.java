package com.bookkarle.offers.strategy.impl;

import com.bookkarle.offers.entity.Offer;
import com.bookkarle.offers.model.OfferEligibilityRequest;
import com.bookkarle.offers.model.OfferEligibilityResponse;
import com.bookkarle.offers.strategy.OfferEligibilityStrategy;
import com.bookkarle.offers.util.OfferCalcUtil;

import java.math.BigDecimal;

public class QuantityBasedEligibility implements OfferEligibilityStrategy {
    @Override
    public OfferEligibilityResponse calculate(OfferEligibilityRequest offerEligibilityRequest, Offer offer) {
        OfferEligibilityResponse offerEligibilityResponse = new OfferEligibilityResponse();
        if(offer.getMinQuantity()<=offerEligibilityRequest.getTicketQuantity()){
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
