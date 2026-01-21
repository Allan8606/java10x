package com.allan.dev.MovieFlix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @Schema(type = "string", description = "Email do usuário")
        @Email(message = "Digite um email valido")
        @NotBlank(message = "O email é Obrigatório")
        String email,

        @Schema(type = "string", description = "Senha do usuário")
        @NotEmpty(message = "A senha é Obrigatório")
        String password) {
}
