package com.bookkarle.booking.partner.impl;

import com.bookkarle.booking.model.ChangeBookingStatusDto;
import com.bookkarle.booking.partner.PartnerApiInterface;

public class PVRApi implements PartnerApiInterface {
    @Override
    public boolean changeBookingStatus(ChangeBookingStatusDto changeBookingStatusDto) {
        //TODO logic to communicate with PVR
        return true;
    }
}
