package com.bookkarle.booking.payment;

import com.bookkarle.booking.entity.BookingOrder;
import com.bookkarle.booking.model.PaymentOrderResponse;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Service
public class PaymentServiceInterfaceImpl implements PaymentServiceInterface {
    private static String RAZOR_PAY_URL="https://api.razorpay.com/v1/orders";

    private final String rajorPayKey;
    private final String rajorPaySecret;

    public PaymentServiceInterfaceImpl(RestTemplate restTemplate, @Value("${rajorpay.key}") String rajorPayKey,
                                       @Value("${rajorpay.secret}") String rajorPaySecret) {
        this.rajorPayKey = rajorPayKey;
        this.rajorPaySecret = rajorPaySecret;
    }

    @Override
    @SneakyThrows
    public PaymentOrderResponse createPaymentOrder(BookingOrder paymentOrder) {

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", paymentOrder.getAmountAfterOffer().longValue()*100); // amount in the smallest currency unit(Paisa)
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", paymentOrder.getBookingId());
        RazorpayClient razorpayClient = new RazorpayClient(rajorPayKey, rajorPaySecret);
        Order order = razorpayClient.orders.create(orderRequest);
        JSONObject json = order.toJson();
        PaymentOrderResponse response = new PaymentOrderResponse(true,
                paymentOrder.getPaymentGatewayId(),
                json.getString("id"),
                null,
                json.getString("status")
        );
        return response;
    }

    HttpHeaders createHeaders(){
        return new HttpHeaders() {{
            String auth = rajorPayKey + ":" + rajorPaySecret;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            setContentType(MediaType.APPLICATION_JSON);
        }};
    }
}

