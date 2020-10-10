package com.smart.demo.conf;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class CachingConfiguration {

    @Bean
    public CacheManager cacheManager() {
        CacheManager cacheManager = new SimpleCacheManager();

        Cache cache = new CaffeineCache("test", Caffeine.newBuilder()
                .recordStats()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10_000)
                .build());

        ((SimpleCacheManager)cacheManager).setCaches(Collections.singletonList(new DeactivatableCache( cache, false)));
        return cacheManager;
    }
}
