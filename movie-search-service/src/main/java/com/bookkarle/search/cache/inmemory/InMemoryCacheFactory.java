package com.bookkarle.search.cache.inmemory;


import com.bookkarle.search.cache.CacheApi;
import com.bookkarle.search.entity.ActiveShow;
import com.bookkarle.search.model.SeatMapDto;
import com.bookkarle.search.model.ShowTierPriceDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InMemoryCacheFactory {

    @Qualifier("seatMapCache")
    @ConditionalOnProperty(value="redis.enabled", matchIfMissing = true, havingValue="no")
    @Bean
    public CacheApi<Long, List<SeatMapDto>> getSeatMapCache(){
        return new InMemoryApiImpl<>();

    }

    @ConditionalOnProperty(value="redis.enabled", matchIfMissing = true, havingValue="no")
    @Qualifier("movieCache")
    @Bean
    public CacheApi<String, List<ActiveShow>> getMovieCache(){
        return new InMemoryApiImpl<>();

    }

    @Qualifier("theatreCache")
    @ConditionalOnProperty(value="redis.enabled", matchIfMissing = true, havingValue="no")
    @Bean
    public CacheApi<String, List<ActiveShow>> getTheatreCacheCache(){
        return new InMemoryApiImpl<>();

    }

    @Qualifier("showTierPriceCache")
    @ConditionalOnProperty(value="redis.enabled", matchIfMissing = true, havingValue="no")
    @Bean
    public CacheApi<Long, List<ShowTierPriceDto>> getShowTierPriceCache(){
        return new InMemoryApiImpl<>();

    }
}
