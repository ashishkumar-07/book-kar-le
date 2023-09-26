package com.bookkarle.booking.dao;

import com.bookkarle.booking.entity.BookingOrder;
import com.bookkarle.booking.entity.ShowMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShowMetaDataDao extends JpaRepository<ShowMetaData, UUID> {
}
