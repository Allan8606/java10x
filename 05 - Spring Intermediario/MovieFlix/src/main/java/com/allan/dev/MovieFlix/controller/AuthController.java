package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.controller.request.LoginRequest;
import com.allan.dev.MovieFlix.controller.request.UserRequest;
import com.allan.dev.MovieFlix.controller.response.LoginResponse;
import com.allan.dev.MovieFlix.controller.response.UserResponse;
import com.allan.dev.MovieFlix.service.AuthApplicationService;
import com.allan.dev.MovieFlix.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
@Tag(name = "AuthController", description = "Recurso responsável pelo gerenciamento de autenticação, para login e para fazer o cadastramento de novos usuarios")
public class AuthController {

    private final UserService userService;
    private final AuthApplicationService authApplicationService;


    @Operation(
            summary = "Registra um novo usuário",
            description = "Método responsável por cadastrar um novo usuário"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Usuário cadastrado com sucesso"
    )
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest userRequest){
        UserResponse registrar = userService.registrar(userRequest);

        return ResponseEntity.ok(registrar);
    }

    @Operation(
            summary = "Realiza o login do usuário já cadastrado",
            description = "Método responsável por realizar o login do usuário já cadastrado"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Login realizado com sucesso"
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authApplicationService.login(loginRequest));
    }

}
