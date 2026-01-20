package com.allan.dev.MovieFlix.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        @NotEmpty(message = "O título do Filme é Obrigatório")
        String title,

        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate releaseDate,

        double rating,

        List<Long> category,

        List<Long> streaming) { }
