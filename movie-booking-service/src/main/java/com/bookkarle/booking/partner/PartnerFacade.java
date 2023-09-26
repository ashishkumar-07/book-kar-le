package com.bookkarle.booking.partner;


import com.bookkarle.OperationFailedException;
import com.bookkarle.booking.entity.BookingOrder;
import com.bookkarle.booking.entity.SeatBookingStatus;
import com.bookkarle.booking.entity.ShowSeatBooking;
import com.bookkarle.booking.model.ChangeBookingStatusDto;
import com.bookkarle.booking.model.CreateBookingOrder;
import com.bookkarle.booking.model.HoldRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerFacade {
    private final PartnerApiInterface partnerApiInterface;

    public void blockSeatInPartnerSystem(HoldRequest holdRequest) {
        //Prepare change Booking status DTO
        ChangeBookingStatusDto dto = ChangeBookingStatusDto.builder().bookingStatus(SeatBookingStatus.HOLD)
                //populate other details
                .build();
        try {
            partnerApiInterface.changeBookingStatus(dto);
        }catch(Exception e){
            throw new OperationFailedException("Partner API returned error");
        }
    }

    public void updateBookingInProgressPartnerSystem(List<ShowSeatBooking> seatsToBook, CreateBookingOrder order) {
        //Prepare change Booking status DTO
        ChangeBookingStatusDto dto = ChangeBookingStatusDto.builder().bookingStatus(SeatBookingStatus.IN_PROGRESS)
                //populate other details
                .build();
        try {
            partnerApiInterface.changeBookingStatus(dto);
        }catch(Exception e){
            throw new OperationFailedException("Partner API returned error");
        }
    }

    public void confirmOrder(BookingOrder bookingOrder) {
    }
}