package com.allan.dev.MovieFlix.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @Email(message = "Digite um email valido")
        @NotBlank(message = "O email é Obrigatório")
        String email,

        @NotEmpty(message = "A senha é Obrigatório")
        String password) {
}
