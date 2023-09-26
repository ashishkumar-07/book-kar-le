package com.bookkarle.booking.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ConfirmOrderResponse {
    private UUID bookingOrderId;
    private String paymentGatewayOrderId;
    private String paymentGatewayOrderStatus;
}
