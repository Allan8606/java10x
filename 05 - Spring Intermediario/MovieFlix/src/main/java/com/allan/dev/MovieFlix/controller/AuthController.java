package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.controller.request.LoginRequest;
import com.allan.dev.MovieFlix.controller.request.UserRequest;
import com.allan.dev.MovieFlix.controller.response.LoginResponse;
import com.allan.dev.MovieFlix.controller.response.UserResponse;
import com.allan.dev.MovieFlix.service.AuthApplicationService;
import com.allan.dev.MovieFlix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthApplicationService authApplicationService;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        UserResponse registrar = userService.registrar(userRequest);

        return ResponseEntity.ok(registrar);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authApplicationService.login(loginRequest));
    }

}
