package com.bookkarle.offers.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
public class OfferEligibilityRequest {
    @NotBlank
    private Long offerId;
    private Long cityId;
    private Long theaterId;
    private Integer ticketQuantity;
    private ZonedDateTime showTime;
    private BigDecimal bookingAmountBeforeOffer;
}
