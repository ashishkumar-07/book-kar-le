package com.bookkarle.offers.dao;


import com.bookkarle.offers.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferDao extends JpaRepository<Offer,Long> {

    @Query(nativeQuery = true, value = """
            select * from offer 
            where city_id=:cityId and theatreId= :theatreId
            and   offer_expiration_date_time > NOW()
            and   offer_effective_date_time < CURRENT_DATETIME   
            LIMIT 100       
            """)
    List<Offer> findByCityIdAndTheatreId(Long cityId, Long theatreId);
}
