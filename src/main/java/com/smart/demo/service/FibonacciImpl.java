package com.smart.demo.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "test")
public class FibonacciImpl implements Fibonacci {

    @Override
    @Cacheable(key = "#count")
    public Integer getFib(int count) {
        return fibonacci(count);
    }

    @Override
    public int fibonacci(int number){
        if(number <= 1) return number;
        return fibonacci(number-1)+fibonacci(number-2);
    }
}
