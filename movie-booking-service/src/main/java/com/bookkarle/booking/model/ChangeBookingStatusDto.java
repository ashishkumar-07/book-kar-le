package com.bookkarle.booking.model;


import com.bookkarle.booking.entity.SeatBookingStatus;
import lombok.Data;

@Data
public class ChangeBookingStatusDto {
    private String externalTheatrePartnerId;
    private String rowNumber;
    private String seatNumber;
    private SeatBookingStatus bookingStatus;
}
