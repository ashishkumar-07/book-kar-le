package com.bookkarle.booking.payment;


import lombok.Data;


public record RazorPayOrderRequest(
    long amount,
    String currency,
    String receipt){   }
