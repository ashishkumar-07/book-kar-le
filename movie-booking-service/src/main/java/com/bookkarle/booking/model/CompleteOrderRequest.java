package com.bookkarle.booking.model;

import lombok.Data;

import java.util.UUID;

@Data
public class CompleteOrderRequest {
    private UUID bookingOrderId;
    private String paymentGatewayTransactionId;
}
