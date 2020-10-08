package com.smart.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciImpl implements Fibonacci {
    @Override
    public Integer getFib(int count) {
        return fibonacci(count);
    }
    private int fibonacci(int number){
        if(number <= 1) return number;
        return fibonacci(number-1)+fibonacci(number-2);
    }
}
