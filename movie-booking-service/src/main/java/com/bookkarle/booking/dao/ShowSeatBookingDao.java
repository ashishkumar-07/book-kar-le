package com.bookkarle.booking.dao;


import com.bookkarle.booking.entity.SeatBookingStatus;
import com.bookkarle.booking.entity.ShowSeatBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatBookingDao extends JpaRepository<ShowSeatBooking,Long> {
    List<ShowSeatBooking> findByShowId(Long showId);

    @Modifying
    @Query(nativeQuery = true, value = """
            update show_seat_booking set booking_status=:bookStatus 
            where booking_status=:currentStatus
            and show_seat_id in(:showSeatIds)
            """)
    int updateBySeatBookingStatusAndShowSeatIdIn(String bookStatus, String currentStatus,List<Long> showSeatIds);

    List<ShowSeatBooking> findByBookingStatusAndShowSeatIdIn(SeatBookingStatus seatBookingStatus, List<Long> seats);

}
