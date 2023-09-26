package com.bookkarle.booking.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateBookingOrder {
    private String userId;
    private Long showId;
    private List<Long> seatIds;
    private Integer ticketQuantity;
    private BigDecimal totalTicketPrice;
    private BigDecimal offerAmount;
    private BigDecimal amountAfterOffer;
    private Long offerId;
    private String paymentGatewayId;

}
