package com.bookkarle.booking.model;


import lombok.Data;

@Data
public class ConfirmOrderRequest {
    private String bookingOrderId;
    private String paymentGatewayId;
}
