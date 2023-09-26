package com.bookkarle.booking.model;


import com.bookkarle.booking.entity.SeatBookingStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChangeBookingStatusDto {
    private String externalTheatrePartnerId;
    private String externalShowId;
    private SeatBookingStatus bookingStatus;
    private List<SeatsToBook> seatsToBook;
}
