package com.bookkarle.booking.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateBookingOrder {
    private String userId;
    private Long cityId;
    private Long theatreId;
    private Long auditoriumId;
    private Long movieId;
    private String language;
    private Long showId;
    private List<Long> seats;
    private Integer ticketQuantity;
    private BigDecimal totalTicketPrice;
    private BigDecimal offerAmount;
    private BigDecimal amountAfterOffer;
    private Long offerId;

}
