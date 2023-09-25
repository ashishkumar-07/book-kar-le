package com.bookkarle.booking.partner.impl;

import com.bookkarle.booking.model.ChangeBookingStatusDto;
import com.bookkarle.booking.partner.PartnerApiInterface;

public class InoxApi implements PartnerApiInterface {
    @Override
    public boolean changeBookingStatus(ChangeBookingStatusDto changeBookingStatusDto) {
        //TOD Inox integration
        return true;
    }
}
