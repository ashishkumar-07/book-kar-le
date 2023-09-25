package com.bookkarle.search.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowTierDetail {
    Tier tierName;
    BigDecimal tierPrice;
    TierBookingStatus tierBookingStatus;
}
