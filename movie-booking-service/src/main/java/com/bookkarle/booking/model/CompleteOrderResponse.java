package com.bookkarle.booking.model;

import lombok.Data;

@Data
public class CompleteOrderResponse {
    private String paymentStatus;
    private String ticketQrCodePath;
    private String ticketImagePath;
}
