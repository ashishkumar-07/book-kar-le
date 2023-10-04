package com.bookkarle.search.cache.redis;

import com.bookkarle.search.cache.CacheApi;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCacheImpl<K,V> implements CacheApi<K,V> {
    HashOperations<String,K,V> hashOperations;
    private String redisKey;
    public RedisCacheImpl(String redisKey, RedisTemplate<K,V> template){
        hashOperations= (HashOperations<String, K, V>) template.opsForHash();
        this.redisKey = redisKey;
    }
    @Override
    public boolean put(K userKey, V value) {
        hashOperations.put(redisKey,userKey,value);
        return true;
    }

    @Override
    public V get(K userKey) {
        return hashOperations.get(redisKey,userKey);
    }
}
