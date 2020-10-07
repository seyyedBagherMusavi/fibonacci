package com.smart.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class FiboRestController {
    @GetMapping
    public ResponseEntity<String> fibo(){
        return new ResponseEntity<>("done!", HttpStatus.ACCEPTED);
    }
}
