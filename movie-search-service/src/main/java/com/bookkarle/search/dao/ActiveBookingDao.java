package com.bookkarle.search.dao;

import com.bookkarle.search.entity.ActiveShowBookedSeat;
import com.bookkarle.search.model.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ActiveBookingDao extends JpaRepository<ActiveShowBookedSeat,Long> {

//    @Query(value = "select tier,count(1) from active_show_booked_seat group by tier",nativeQuery = true)
//    Map<Tier,Long> findTotalTierWiseCountByShowId(Long showId);

    Set<Long> findSeatIdByShowId(Long showId);
}
