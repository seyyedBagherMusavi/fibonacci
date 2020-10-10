package com.smart.demo.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.support.NoOpCache;

import java.util.concurrent.Callable;
@Slf4j
public class DeactivatableCache implements Cache {
    private final Cache delegate;
    private final NoOpCache noOpCache;

    public static boolean cacheDisabler = false;
    private final boolean disabledByDefault;

    public DeactivatableCache(Cache delegate, boolean disabledByDefault) {
        this.delegate = delegate;
        this.disabledByDefault = disabledByDefault;
        this.noOpCache = new NoOpCache(delegate.getName());
    }

    // Some boring methods omitted - they just call the same method on delegate cache

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public Object getNativeCache() {
        return this;
    }

    @Override
    public ValueWrapper get(Object key) {
        if (isCacheDisabled()) {
            return noOpCache.get(key);
        }

        return delegate.get(key);
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        if (isCacheDisabled()) {
            return noOpCache.get(key, type);
        }

        return delegate.get(key, type);
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        if (isCacheDisabled()) {
            return noOpCache.get(key, valueLoader);
        }

        return delegate.get(key, valueLoader);
    }

    @Override
    public void put(Object key, Object value) {
        if (isCacheDisabled()) {
            noOpCache.put(key, value);
            return;
        }

        delegate.put(key, value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        if (isCacheDisabled()) {
            return noOpCache.putIfAbsent(key, value);
        }

        return delegate.putIfAbsent(key, value);
    }

    @Override
    public void evict(Object key) {
        if (isCacheDisabled()) {
            noOpCache.evict(key);
            return;
        }

        delegate.evict(key);
    }

    @Override
    public void clear() {
        if (isCacheDisabled()) {
            noOpCache.clear();
            return;
        }

        delegate.clear();
    }

    private boolean isCacheDisabled() {

        return cacheDisabler;
    }
}
