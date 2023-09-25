package com.bookkarle.booking.partner;

import com.bookkarle.booking.model.ChangeBookingStatusDto;

public interface PartnerApiInterface {

    public boolean changeBookingStatus(ChangeBookingStatusDto changeBookingStatusDto);
}
