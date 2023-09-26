package com.bookkarle.booking.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class CreateBookingOrderResponse {
    private UUID bookingOrderId;
    private BigDecimal convenienceFee;
    private BigDecimal baseAmountOfFee;
    private BigDecimal taxOnFee;

}
