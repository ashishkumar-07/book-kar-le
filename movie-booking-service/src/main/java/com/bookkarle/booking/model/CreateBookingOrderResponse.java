package com.bookkarle.booking.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateBookingOrderResponse {
    private String bookingOrderId;
    private BigDecimal convenienceFee;
    private BigDecimal baseAmountOfFee;
    private BigDecimal tax;

}
