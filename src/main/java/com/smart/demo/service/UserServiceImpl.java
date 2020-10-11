package com.smart.demo.service;

import com.smart.demo.model.User;
import com.smart.demo.repo.UserRepository;
import com.smart.demo.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto.UserInfo save(UserDto.UserCreate userCreate) {
        userCreate.setPassword(bCryptPasswordEncoder.encode(userCreate.getPassword()));
        User user = modelMapper.map(userCreate, User.class);
        userRepository.save(user);

        return modelMapper.map(user,UserDto.UserInfo.class);
    }

    @Override
    public List<UserDto.UserInfo> list() {
        List<User> users = userRepository.findAll();
        return modelMapper.map(users,new TypeToken<List<UserDto.UserInfo>>(){}.getType());
    }
}
