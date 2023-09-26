package com.bookkarle.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder

public class BookingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookingId;
    private String externalBookingId;
    private String userId;
    private BookingOrderStatus orderStatus;
    private String showId;

    private List<Long> seatIds;
    private Integer ticketQuantity;
    private Long offerId;
    private BigDecimal totalTicketPrice;
    private BigDecimal offerAmount;
    private BigDecimal amountAfterOffer;
    private BigDecimal convenienceFee;
    private BigDecimal baseAmountOfFee;
    private BigDecimal taxOnFee;

    private String paymentGatewayId;
    private String paymentGatewayOrderId;
    private String  paymentGatewayTransactionId;
    private String  paymentGatewayOrderStatus;

    private String ticketQrCodePath;
    private String ticketImagePath;




}
