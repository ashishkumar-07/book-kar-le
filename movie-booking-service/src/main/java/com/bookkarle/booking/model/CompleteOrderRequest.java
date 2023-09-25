package com.bookkarle.booking.model;

import lombok.Data;

@Data
public class CompleteOrderRequest {
    private String bookingOrderId;
    private String paymentGatewayTransactionId;
}
