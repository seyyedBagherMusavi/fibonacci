package com.smart.demo.service;

import com.smart.demo.service.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto.UserInfo save(UserDto.UserCreate userCreate);
    List<UserDto.UserInfo> list();
}
