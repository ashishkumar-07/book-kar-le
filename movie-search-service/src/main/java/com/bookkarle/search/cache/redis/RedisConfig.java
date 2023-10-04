package com.bookkarle.search.cache.redis;


import com.bookkarle.search.cache.CacheApi;
import com.bookkarle.search.cache.inmemory.InMemoryApiImpl;
import com.bookkarle.search.entity.ActiveShow;
import com.bookkarle.search.model.SeatMapDto;
import com.bookkarle.search.model.ShowTierPriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.List;

@Configuration
@Slf4j
public class RedisConfig {
    @Bean
    @ConditionalOnProperty(value="redis.enabled", matchIfMissing = false, havingValue="yes")
    public JedisConnectionFactory redisConnectionFactory() {
        log.info("configuring redis cache");
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("redis");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("redis123");
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
    public RedisTemplate<Long, List<SeatMapDto>> redisTemplateSeatMap() {
        RedisTemplate<Long, List<SeatMapDto>> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    public RedisTemplate<String, List<ActiveShow>> redisTemplateMovie() {
        RedisTemplate<String, List<ActiveShow>> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    public RedisTemplate<String, List<ActiveShow>> redisTemplateTheatre() {
        RedisTemplate<String, List<ActiveShow>> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    private RedisTemplate<Long, List<ShowTierPriceDto>> redisTemplateTierPrice() {
        RedisTemplate<Long, List<ShowTierPriceDto>> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Qualifier("seatMapCache")
    @Bean
    @ConditionalOnProperty(value="redis.enabled", matchIfMissing = false, havingValue="yes")
    public CacheApi<Long, List<SeatMapDto>> getSeatMapCache(){
        return new RedisCacheImpl<>("SEAT_MAP",redisTemplateSeatMap());

    }
    @Qualifier("movieCache")
    @Bean
    @ConditionalOnProperty(value="redis.enabled", matchIfMissing = false, havingValue="yes")
    public CacheApi<String, List<ActiveShow>> getMovieCache(){
        return new RedisCacheImpl<>("MOVIE",redisTemplateMovie());

    }

    @Qualifier("theatreCache")
    @Bean
    @ConditionalOnProperty(value="redis.enabled", matchIfMissing = false, havingValue="yes")
    public CacheApi<String, List<ActiveShow>> getTheatreCacheCache(){
        return  new RedisCacheImpl<>("THEATRE",redisTemplateTheatre());

    }
    @Qualifier("showTierPriceCache")
    @Bean
    @ConditionalOnProperty(value="redis.enabled", matchIfMissing = false, havingValue="yes")
    public CacheApi<Long, List<ShowTierPriceDto>> getShowTierPriceCache(){

        return new RedisCacheImpl<>("SHOW_TIER_PRICE",redisTemplateTierPrice());

    }


}
