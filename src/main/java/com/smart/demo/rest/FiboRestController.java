package com.smart.demo.rest;

import com.smart.demo.conf.CachingConfiguration;
import com.smart.demo.conf.DeactivatableCache;
import com.smart.demo.service.Fibonacci;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "/api2")
public class FiboRestController {
    private final Fibonacci fibonacci;

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<Integer> fibo(@RequestParam("fibNumber") int fibNumber){
        int fib = fibonacci.getFib(fibNumber);
        return new ResponseEntity<>(fib, HttpStatus.ACCEPTED);
    }

    @GetMapping("/disable")
    public ResponseEntity<String> disableCache(){
        DeactivatableCache.cacheDisabler = true;
        return new ResponseEntity<>("disable cache",HttpStatus.ACCEPTED);
    }

    @GetMapping("/enable")
    public ResponseEntity<String> enableCache(){
        DeactivatableCache.cacheDisabler = false;
        return new ResponseEntity<>("enable cache",HttpStatus.ACCEPTED);
    }


}
