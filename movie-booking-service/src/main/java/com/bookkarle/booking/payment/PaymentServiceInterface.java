package com.bookkarle.booking.payment;

import com.bookkarle.booking.entity.BookingOrder;
import com.bookkarle.booking.model.PaymentOrderResponse;

public interface PaymentServiceInterface {
    PaymentOrderResponse createPaymentOrder(BookingOrder paymentOrder);
}
