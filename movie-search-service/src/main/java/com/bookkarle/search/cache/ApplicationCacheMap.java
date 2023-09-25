package com.bookkarle.search.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApplicationCacheMap<K,V> extends LinkedHashMap<K,V> {
    private static int CAPACITY = 100;
    public ApplicationCacheMap() {
        super(100,.9f,true);
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size()>CAPACITY  ? true : false;
    }

}
