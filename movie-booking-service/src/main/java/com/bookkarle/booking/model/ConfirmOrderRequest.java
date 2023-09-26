package com.bookkarle.booking.model;


import lombok.Data;

import java.util.UUID;

@Data
public class ConfirmOrderRequest {
    private UUID bookingOrderId;
    private String paymentGatewayId;
}
