package com.bookkarle.booking.model;


import lombok.Data;


public record PaymentOrderResponse(boolean status,String paymentGatewayId,
                                   String paymentGatewayOrderId,String  paymentGatewayTransactionId,
                                   String  paymentGatewayOrderStatus){
}

