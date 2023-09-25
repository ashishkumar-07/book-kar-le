package com.bookkarle.booking.api;

import com.bookkarle.booking.entity.BookingOrder;
import com.bookkarle.booking.entity.ShowSeatBooking;
import com.bookkarle.booking.model.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface BookingApi {

    @Operation(summary = "Get seat layout of a particular show with seat status")
    public List<ShowSeatBooking> seatMap(Long showId);

    @Operation(summary = "Hold the seats selected by user")
    public void putOnHold(HoldRequest holdRequest);

    @Operation(summary = "Create a pending order and get the final price details along with fees and offers")
    public CreateBookingOrderResponse createOrder(CreateBookingOrder order);

    @Operation(summary = "marks order in-progress and initiate the payment with payment gateway")
    public ConfirmOrderResponse confirmOrder(ConfirmOrderRequest order);

    @Operation(summary = "Once the user completes the payment from UI then UI call this " +
            "API to mark the order complete and fetch the ticket status")
    public CompleteOrderResponse completeOrder(CompleteOrderRequest order);
    @Operation(summary = "Check current active order status of a particular user")
    public BookingOrder checkCurrentOrderStatus(String userId);
    @Operation(summary = "Fetch ticket details of particular order")
    public BookingOrder fetchTicket(String userId, String BookingOrderId);

}
