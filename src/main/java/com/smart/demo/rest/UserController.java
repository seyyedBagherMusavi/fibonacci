package com.smart.demo.rest;

import com.smart.demo.service.UserService;
import com.smart.demo.service.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/add")
    public ResponseEntity<UserDto.UserInfo> add( UserDto.UserCreate userCreate){
        return new ResponseEntity<>(userService.save(userCreate), HttpStatus.ACCEPTED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<UserDto.UserInfo>> list(){
        return new ResponseEntity<>(userService.list(), HttpStatus.ACCEPTED);
    }
}
