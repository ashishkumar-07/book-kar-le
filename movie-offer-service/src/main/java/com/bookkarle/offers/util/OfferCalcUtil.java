package com.bookkarle.offers.util;

import java.math.BigDecimal;

public class OfferCalcUtil {
    public static BigDecimal getFixedAmount(BigDecimal bookingAmountBeforeOffer, Integer offerValue) {
        BigDecimal offerAmount = bookingAmountBeforeOffer.multiply(BigDecimal.valueOf(offerValue)).divide(BigDecimal.valueOf(100));
        return offerAmount.compareTo(bookingAmountBeforeOffer) > 0 ? bookingAmountBeforeOffer : offerAmount;
    }

    public static BigDecimal getPercentageAmount(BigDecimal bookingAmountBeforeOffer, Integer offerValue) {
        BigDecimal offerAmount = BigDecimal.valueOf(offerValue);
        return offerAmount.compareTo(bookingAmountBeforeOffer) > 0 ? bookingAmountBeforeOffer : offerAmount;
    }
}
