package com.allan.dev.MovieFlix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @Schema(type = "String", description = "Nome da Categoria")
        @NotBlank(message = "Nome da Categoria é Obrigatório")
        String name) {
}
