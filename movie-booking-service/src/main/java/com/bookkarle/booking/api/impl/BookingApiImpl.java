package com.bookkarle.booking.api.impl;

import com.bookkarle.booking.api.BookingApi;
import com.bookkarle.booking.entity.BookingOrder;
import com.bookkarle.booking.entity.ShowSeatBooking;
import com.bookkarle.booking.model.*;
import com.bookkarle.booking.service.BookingFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class BookingApiImpl implements BookingApi {
    private final BookingFacade bookingFacade;
    @GetMapping("/seat-layout/{showId}")
    @Override
    public List<ShowSeatBooking> seatMap(@PathVariable Long showId) {

        return bookingFacade.fetchSeatMap(showId);
    }

    @PostMapping("/hold")
    @Override
    public void putOnHold(@RequestBody @Valid HoldRequest holdRequest) {
             bookingFacade.blockSeat(holdRequest);
    }

    @PostMapping("/place")
    @Override
    public CreateBookingOrderResponse createOrder(@RequestBody @Valid CreateBookingOrder order) {
        return bookingFacade.createOrder(order);
    }

    @PatchMapping("/confirm")
    @Override
    public ConfirmOrderResponse confirmOrder(@RequestBody @Valid ConfirmOrderRequest order) {
        return bookingFacade.confirmOrder(order);
    }

    @PatchMapping("/complete")
    @Override
    public CompleteOrderResponse completeOrder(@RequestBody @Valid CompleteOrderRequest order) {
        return bookingFacade.completeOrder(order);
    }


    @GetMapping("/order-status/{userId}")
    @Override
    public BookingOrder checkCurrentOrderStatus(@PathVariable @Valid String userId) {
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
