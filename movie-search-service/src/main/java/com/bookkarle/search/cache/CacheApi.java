package com.bookkarle.search.cache;

public interface CacheApi<K,V> {

    public boolean put(K key, V value);
    public V get(K key);
}
