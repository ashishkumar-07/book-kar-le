package com.bookkarle.booking.api;

import com.bookkarle.booking.entity.BookingOrder;
import com.bookkarle.booking.entity.ShowSeatBooking;
import com.bookkarle.booking.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class BookingApiImpl implements BookingApi {

    @GetMapping("/seat-layout/{showId}")
    @Override
    public List<ShowSeatBooking> seatMap(@PathVariable Long showId) {
        return null;
    }

    @PostMapping("/hold")
    @Override
    public void putOnHold(@RequestBody HoldRequest holdRequest) {

    }

    @PostMapping("/place")
    @Override
    public CreateBookingOrderResponse createOrder(@RequestBody CreateBookingOrder order) {
        return null;
    }

    @PatchMapping("/confirm")
    @Override
    public ConfirmOrderResponse confirmOrder(@RequestBody ConfirmOrderRequest order) {
        return null;
    }

    @PatchMapping("/complete")
    @Override
    public CompleteOrderResponse completeOrder(@RequestBody CompleteOrderRequest order) {
        return null;
    }


    @GetMapping("/order-status/{userId}")
    @Override
    public BookingOrder checkCurrentOrderStatus(@PathVariable String userId) {
        return null;
    }

    @GetMapping("/order-status/{userId}/{BookingOrderId}")
    @Override
    public BookingOrder fetchTicket(@PathVariable String userId, String BookingOrderId) {
        return null;
    }

    @Override
    public void cancelBooking(String userId, String BookingOrderId) {
        ;
    }
}
