package com.allan.dev.MovieFlix.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserRequest(
        @NotEmpty(message = "O nome é Obrigatório")
        String name,

        @NotEmpty(message = "O email é Obrigatório")
        @Email
        String email,

        @NotEmpty(message = "A senha é Obrigatório")
        String password) {
}
