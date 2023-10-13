package com.bookkarle.booking.dao;

import com.bookkarle.booking.entity.BookingOrder;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;
import java.util.UUID;

public interface BookingOrderDao extends JpaRepository<BookingOrder, UUID> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Optional<BookingOrder> findByBookingId(UUID bookingOrderId);
}
