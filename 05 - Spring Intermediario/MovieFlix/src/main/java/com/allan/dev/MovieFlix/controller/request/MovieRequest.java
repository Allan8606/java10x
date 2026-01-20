package com.allan.dev.MovieFlix.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(
        @Schema(type = "String", description = "Nome do filme")
        @NotEmpty(message = "O título do Filme é Obrigatório")
        String title,

        @Schema(type = "String", description = "Descrição do filme")
        String description,

        @Schema(type = "date", description = "Data de lançamento do filme. ex: 20/01/2026")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate releaseDate,

        @Schema(type = "double", description = "Score/nota do filme")
        double rating,

        @Schema(type = "array", description = "Lista de códigos de categorias")
        List<Long> category,

        @Schema(type = "array", description = "Lista de códigos de streaming")
        List<Long> streaming) { }
