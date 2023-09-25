package com.bookkarle.search.cache;


import com.bookkarle.search.entity.ActiveShow;
import com.bookkarle.search.model.SeatMapDto;
import com.bookkarle.search.model.ShowTierPriceDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InMemoryCacheFactory {

    @Qualifier("seatMapCache")
    @Bean
    public CacheApi<Long, List<SeatMapDto>> getMovieCache(){
        return new InMemoryApiImpl<>();

    }

    @Qualifier("movieCache")
    @Bean
    public CacheApi<String, List<ActiveShow>> getSeatMapCache(){
        return new InMemoryApiImpl<>();

    }

    @Qualifier("theatreCache")
    @Bean
    public CacheApi<String, List<ActiveShow>> getTheatreCacheCache(){
        return new InMemoryApiImpl<>();

    }

    @Qualifier("showTierPriceCache")
    @Bean
    public CacheApi<Long, List<ShowTierPriceDto>> getShowTierPriceCache(){
        return new InMemoryApiImpl<>();

    }
}
