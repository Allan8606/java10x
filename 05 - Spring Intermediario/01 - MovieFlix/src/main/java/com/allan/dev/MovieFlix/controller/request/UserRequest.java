package com.allan.dev.MovieFlix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record UserRequest(

        @Schema(type = "string", description = "Nome do usuário")
        @NotBlank(message = "O nome é Obrigatório")
        String name,

        @Schema(type = "string", description = "Email do usuário")
        @NotEmpty(message = "O email é Obrigatório")
        @Email(message = "O email deve ser válido")
        String email,

        @Schema(type = "string", description = "Senha do usuário")
        @NotEmpty(message = "A senha é Obrigatório")
        String password) {
}
