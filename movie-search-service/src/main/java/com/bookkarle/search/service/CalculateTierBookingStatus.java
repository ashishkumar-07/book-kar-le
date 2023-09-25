package com.bookkarle.search.service;

import com.bookkarle.search.cache.CacheApi;
import com.bookkarle.search.dao.ActiveBookingDao;
import com.bookkarle.search.entity.ActiveShow;
import com.bookkarle.search.model.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Service

public class CalculateTierBookingStatus {
    private static Map<TierBookingStatus, Integer> TIER_FULL_STATUS_MAP
            = Map.of( TierBookingStatus.Available, 50,
            TierBookingStatus.FillingFast,70,
            TierBookingStatus.AlmostFilled, 90,
            TierBookingStatus.SoldOut, 100);

    private final ActiveBookingDao activeBookingDao;
    private final CacheApi<Long, List<ShowTierPriceDto>> showTierPriceCache;
    private final CacheApi<Long, List<SeatMapDto>> seatMapCache;

    public CalculateTierBookingStatus(ActiveBookingDao activeBookingDao,
                                      @Qualifier("showTierPriceCache") CacheApi<Long, List<ShowTierPriceDto>> showTierPriceCache,
                                      @Qualifier("seatMapCache") CacheApi<Long, List<SeatMapDto>> seatMapCache) {
        this.activeBookingDao = activeBookingDao;
        this.showTierPriceCache = showTierPriceCache;
        this.seatMapCache = seatMapCache;
    }

    public List<ShowTierDetail> buildShowTierDetail(ActiveShow activeShow) {

        Set<Long> bookedSeats = activeBookingDao.findSeatIdByShowId( activeShow.getShowId());
        Map<Tier, Long> tierWiseTotalCount = seatMapCache.get(activeShow.getAuditoriumId()).stream()
                .collect(Collectors.groupingBy(SeatMapDto::getTier,Collectors.counting()));

        Map<Tier, Long> tierWiseBookedCount = seatMapCache.get(activeShow.getAuditoriumId())
                .stream()
                .filter(seat -> bookedSeats.contains(seat.getSeatId()))
                .collect(Collectors.groupingBy(SeatMapDto::getTier, Collectors.counting()));

        Map<Tier, TierBookingStatus> tierAndTierBookingStatusMap =
                tierWiseBookedCount.entrySet()
                    .stream()
                    .map(t -> new ShowTierDetail(t.getKey(), null, getTierBookingStatus(t.getValue(), tierWiseTotalCount.get(t.getKey()))))
                    .collect(Collectors.toMap(ShowTierDetail::getTierName,ShowTierDetail::getTierBookingStatus));


        return showTierPriceCache.get(activeShow.getShowId()).stream()
                        .map(item->new ShowTierDetail(item.getTierName(),item.getTierPrice(),tierAndTierBookingStatusMap.get(item.getTierName())))
                .toList();
    }



    private TierBookingStatus getTierBookingStatus(Long tierBookedCount, long tierTotalCapacity) {
        long bookPercentage = Math.floorDiv(tierBookedCount * 100, tierTotalCapacity);
        if(bookPercentage<= TIER_FULL_STATUS_MAP.get(TierBookingStatus.Available.toString())){
            return TierBookingStatus.Available;
        }
        else if (bookPercentage<= TIER_FULL_STATUS_MAP.get(TierBookingStatus.FillingFast.toString())){
            return TierBookingStatus.FillingFast;
        }
        else if (bookPercentage<= TIER_FULL_STATUS_MAP.get(TierBookingStatus.AlmostFilled.toString())){
            return TierBookingStatus.AlmostFilled;
        }
        else
            return TierBookingStatus.SoldOut;
    }
}
