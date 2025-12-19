package com.allan.dev.MovieFlix.service;

import com.allan.dev.MovieFlix.controller.request.UserRequest;
import com.allan.dev.MovieFlix.controller.response.UserResponse;
import com.allan.dev.MovieFlix.entity.User;
import com.allan.dev.MovieFlix.mapper.UserMapper;
import com.allan.dev.MovieFlix.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse registrar(UserRequest userRequest){
        User user = UserMapper.paraUser(userRequest);
        User save = userRepository.save(user);
        return UserMapper.paraUserResponse(save);
    }

}
