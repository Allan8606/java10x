package com.allan.dev.MovieFlix.controller;

import com.allan.dev.MovieFlix.controller.request.MovieRequest;
import com.allan.dev.MovieFlix.controller.response.MovieResponse;
import com.allan.dev.MovieFlix.entity.Movie;
import com.allan.dev.MovieFlix.mapper.MovieMapper;
import com.allan.dev.MovieFlix.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
@Tag(name = "Movie", description = "Recurso responsável pelo gerenciamento dos filmes")
public class MovieController {

    private final MovieService movieService;



    @Operation(summary = "Criar Filme", description = "Método responsável por criar um novo filme", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme Salvo com Sucesso",
    content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@Valid @RequestBody MovieRequest request) {
        Movie movie = MovieMapper.paraMovie(request);
        Movie savedMovie = movieService.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MovieMapper.paraMovieResponse(savedMovie));
    }


    @Operation(summary = "Buscar todos os filmes", description = "Método responsável por listar todos os filmes cadastrados", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os fimes cadastrados",
    content = @Content(array = @ArraySchema(schema = @Schema( implementation = MovieResponse.class))))
    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAllMovies() {
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(movie -> MovieMapper.paraMovieResponse(movie))
                .toList());
    }

    @Operation(summary = "Buscar filme pelo ID", description = "Método responsável por busca um filme pelo seu ID", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme encontrado com sucesso",
            content = @Content())
    @ApiResponse(responseCode = "404", description = "Filme não encontrado",
            content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findMovieById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.paraMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(summary = "Buscar filmes pelo ID de categoria", description = "Método responsável por listar todos os filmes cadastrados, usando o ID de uma categoria cadastrada", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filmes encontrado com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema( implementation = MovieResponse.class))))
    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findMoviesByCategoryId(@RequestParam Long category) {
        List<MovieResponse> list = movieService.findByCategory(category).stream()
                .map(movie -> MovieMapper.paraMovieResponse(movie))
                .toList();
        return ResponseEntity.ok(list);
    }


    @Operation(summary = "Atualiza Filme", description = "Método responsável por atualizar um filme", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme atualizado com Sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme não encontrado",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @Valid @RequestBody MovieRequest request) {

        Movie movie = MovieMapper.paraMovie(request);
        return movieService.update(id,movie)
                .map(m -> ResponseEntity.ok(MovieMapper.paraMovieResponse(m)))
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(summary = "Deletar filme pelo ID", description = "Método responsável por deletar um filme pelo seu ID", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Filme deletado com sucesso",
            content = @Content())
    @ApiResponse(responseCode = "404", description = "Filme não encontrado",
            content = @Content())
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
