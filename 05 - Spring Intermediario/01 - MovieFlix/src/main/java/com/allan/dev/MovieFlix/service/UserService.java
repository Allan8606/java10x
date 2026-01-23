package com.allan.dev.MovieFlix.service;

import com.allan.dev.MovieFlix.config.TokenService;
import com.allan.dev.MovieFlix.controller.request.LoginRequest;
import com.allan.dev.MovieFlix.controller.request.UserRequest;
import com.allan.dev.MovieFlix.controller.response.LoginResponse;
import com.allan.dev.MovieFlix.controller.response.UserResponse;
import com.allan.dev.MovieFlix.entity.User;
import com.allan.dev.MovieFlix.mapper.UserMapper;
import com.allan.dev.MovieFlix.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public UserResponse registrar(UserRequest userRequest){
        User user = UserMapper.paraUser(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        return UserMapper.paraUserResponse(save);
    }



}
