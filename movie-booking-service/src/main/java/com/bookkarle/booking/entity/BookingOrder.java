package com.bookkarle.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class BookingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookingId;
    private String externalBookingId;
    private String userId;
    private BookingOrderStatus orderStatus;
    private Long cityId;
    private Long theatreId;
    private Long auditoriumId;
    private Long movieId;
    private String language;
    private Long showId;
    private Integer ticketQuantity;
    private Long offerId;
    private BigDecimal totalTicketPrice;
    private BigDecimal offerAmount;
    private BigDecimal amountAfterOffer;


    private String paymentGatewayId;
    private String paymentGatewayOrderId;
    private String  paymentGatewayTransactionId;
    private String  paymentGatewayOrderStatus;

    private String ticketQrCodePath;
    private String ticketImagePath;
}
