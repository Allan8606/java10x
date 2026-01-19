package com.allan.dev.MovieFlix.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(
        @NotEmpty(message = "Nome da Categoria é Obrigatório")
        String name) {
}
