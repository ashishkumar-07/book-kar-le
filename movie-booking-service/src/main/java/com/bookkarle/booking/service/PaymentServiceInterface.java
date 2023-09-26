package com.bookkarle.booking.service;

import com.bookkarle.booking.model.PaymentOrder;
import com.bookkarle.booking.model.PaymentOrderResponse;

public interface PaymentServiceInterface {
    PaymentOrderResponse createPaymentOrder(PaymentOrder paymentOrder);
}
