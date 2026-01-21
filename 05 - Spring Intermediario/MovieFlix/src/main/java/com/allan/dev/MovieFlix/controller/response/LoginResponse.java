package com.allan.dev.MovieFlix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(
        @Schema(type = "string", description = "Email do usuário")
        String email,

        @Schema(type = "string", description = "Token do usuário")
        String token) {
}
