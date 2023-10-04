package com.bookkarle.search.cache.inmemory;

import com.bookkarle.search.cache.CacheApi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InMemoryApiImpl<K,V> implements CacheApi<K,V> {
    private ApplicationCacheMap<K,V> cache;
    Lock lock = new ReentrantLock();

    public InMemoryApiImpl() {
        this.cache = new ApplicationCacheMap<>();
    }

    @Override
    public  boolean put(K key, V value) {
        try{
            lock.lock();
            cache.put(key,value);
        }
        finally {
            lock.unlock();
        }
        return true;
    }

    @Override
    public  V get(K key) {
        if(lock.tryLock()){
            return cache.get(key);
        }
        return null;
    }
}
