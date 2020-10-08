package com.smart.demo.rest;

import com.smart.demo.service.Fibonacci;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "/api2")
public class FiboRestController {

    private final Fibonacci fibonacci;
    @GetMapping
//    @PreAuthorize("isAuthenticated()")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Integer> fibo(@RequestParam("fibNumber") int fibNumber){
        int fib = fibonacci.getFib(fibNumber);
        return new ResponseEntity<>(fib, HttpStatus.ACCEPTED);
    }



}
