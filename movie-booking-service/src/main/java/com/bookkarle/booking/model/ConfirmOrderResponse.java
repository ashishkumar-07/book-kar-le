package com.bookkarle.booking.model;

import lombok.Data;

@Data
public class ConfirmOrderResponse {
    private String orderId;
    private String paymentGatewayOrderId;
    private String paymentGatewayOrderStatus;
}
