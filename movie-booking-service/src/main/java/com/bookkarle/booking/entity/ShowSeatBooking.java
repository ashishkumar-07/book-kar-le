package com.bookkarle.booking.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
@Data
public class ShowSeatBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showSeatId;

    private long showId;
    private String rowNumber;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatBookingStatus bookingStatus;
    private String bookingOrderId;

    private ZonedDateTime updatedAt;

    @Version
    private Timestamp versionNum;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ShowSeatBooking that = (ShowSeatBooking) object;

        return showSeatId.equals(that.showSeatId);
    }

    @Override
    public int hashCode() {
        return showSeatId.hashCode();
    }
}
