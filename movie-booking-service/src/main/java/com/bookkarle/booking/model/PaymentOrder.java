package com.bookkarle.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

public record PaymentOrder (BigDecimal amount,String paymentGatewayId) {}
