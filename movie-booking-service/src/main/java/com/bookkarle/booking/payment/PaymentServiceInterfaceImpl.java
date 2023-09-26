package com.bookkarle.booking.payment;

import com.bookkarle.booking.model.PaymentOrder;
import com.bookkarle.booking.model.PaymentOrderResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceInterfaceImpl implements PaymentServiceInterface {
    @Override
    public PaymentOrderResponse createPaymentOrder(PaymentOrder paymentOrder) {
        return null;
    }
}
