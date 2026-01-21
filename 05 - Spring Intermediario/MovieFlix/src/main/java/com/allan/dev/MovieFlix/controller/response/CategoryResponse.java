package com.allan.dev.MovieFlix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CategoryResponse(
        @Schema(type = "long", description = "Id do filme")
        Long id,

        @Schema(type = "String", description = "Nome da Categoria")
        String name) {
}
