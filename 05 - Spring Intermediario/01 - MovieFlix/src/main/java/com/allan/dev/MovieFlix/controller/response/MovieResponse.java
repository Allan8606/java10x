package com.allan.dev.MovieFlix.controller.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
                            @Schema(type = "long", description = "Id do filme")
                            Long id,

                            @Schema(type = "String", description = "Nome do filme")
                            String title,

                            @Schema(type = "String", description = "Descrição do filme")
                            String description,

                            @Schema(type = "date", description = "Data de lançamento do filme. ex: 20/01/2026")
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            LocalDate releaseDate,

                            @Schema(type = "date", description = "Data de lançamento do filme. ex: 20/01/2026")
                            double rating,

                            @Schema(type = "date", description = "Data de lançamento do filme. ex: 20/01/2026")
                            List<CategoryResponse> categories,

                            @Schema(type = "array", description = "Lista de códigos de streaming")
                            List<StreamingResponse> streaming
                            ) {
}
