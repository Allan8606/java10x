package com.allan.dev.MovieFlix.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;


public record StreamingRequest(
        @NotEmpty(message = "O nome é Obrigatório")
        String name) {
}
