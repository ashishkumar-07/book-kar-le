package com.bookkarle.offers.model;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;


@Data
@ToString
public final class OfferEligibilityResponse {
    private boolean eligible;
    private BigDecimal offerAmount;
    private Long offerId;

}
