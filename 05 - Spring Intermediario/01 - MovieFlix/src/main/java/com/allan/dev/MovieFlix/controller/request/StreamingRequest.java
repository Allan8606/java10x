package com.allan.dev.MovieFlix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;


public record StreamingRequest(
        @Schema(type = "string", description = "Nome do Streaming")
        @NotEmpty(message = "O nome é Obrigatório")
        String name) {
}
