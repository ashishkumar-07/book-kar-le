package com.bookkarle.booking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompleteOrderResponse {
    private String paymentStatus;
    private String ticketQrCodePath;
    private String ticketImagePath;
}
