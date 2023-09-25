package com.bookkarle.search.cache;

import java.util.LinkedHashMap;

public class InMemoryApiImpl<K,V> implements CacheApi<K,V> {
    private ApplicationCacheMap<K,V> cache;

    public InMemoryApiImpl() {
        this.cache = new ApplicationCacheMap<>();
    }

    @Override
    public synchronized boolean put(K key, V value) {
        //TODO
        return false;
    }

    @Override
    public synchronized V get(K key) {
        //TODO
        return null;
    }
}
