package com.bookkarle.booking.dao;

import com.bookkarle.booking.entity.BookingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingOrderDao extends JpaRepository<BookingOrder, UUID> {
}
