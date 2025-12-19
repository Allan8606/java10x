package com.allan.dev.MovieFlix.mapper;

import com.allan.dev.MovieFlix.controller.request.UserRequest;
import com.allan.dev.MovieFlix.controller.response.UserResponse;
import com.allan.dev.MovieFlix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User paraUser(UserRequest userRequest){
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse paraUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();

    }



}
