package com.allan.dev.MovieFlix.controller;

import com.allan.dev.MovieFlix.controller.request.MovieRequest;
import com.allan.dev.MovieFlix.controller.response.MovieResponse;
import com.allan.dev.MovieFlix.entity.Movie;
import com.allan.dev.MovieFlix.mapper.MovieMapper;
import com.allan.dev.MovieFlix.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAllMovies() {
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(movie -> MovieMapper.paraMovieResponse(movie))
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findMovieById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.paraMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findMoviesByCategoryId(@RequestParam Long category) {
        List<MovieResponse> list = movieService.findByCategory(category).stream()
                .map(movie -> MovieMapper.paraMovieResponse(movie))
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@Valid @RequestBody MovieRequest request) {
        Movie movie = MovieMapper.paraMovie(request);
        Movie savedMovie = movieService.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MovieMapper.paraMovieResponse(savedMovie));
    }

    @PutMapping
    public ResponseEntity<MovieResponse> updateMovie(@Valid @RequestBody MovieRequest request) {
        Movie movie = MovieMapper.paraMovie(request);
        return movieService.update(movie)
                .map(m -> ResponseEntity.ok(MovieMapper.paraMovieResponse(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
