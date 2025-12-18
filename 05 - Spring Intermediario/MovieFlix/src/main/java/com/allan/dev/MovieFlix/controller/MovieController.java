package com.allan.dev.MovieFlix.controller;

import com.allan.dev.MovieFlix.controller.request.MovieRequest;
import com.allan.dev.MovieFlix.controller.response.MovieResponse;
import com.allan.dev.MovieFlix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> savar(@RequestBody MovieRequest request){
        MovieResponse salvar = movieService.salvar(request);
        return ResponseEntity.ok(salvar);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> listarTodos(){
        List<MovieResponse> movieResponses = movieService.listarTodos();

        return ResponseEntity.ok(movieResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> buscarPorId(@PathVariable Long id){
        return movieService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> atualizar(@PathVariable Long id, @RequestBody MovieRequest movieRequest){
        return movieService.atualizar(id, movieRequest)
                .map(movie -> ResponseEntity.ok(movie))
                .orElse(ResponseEntity.notFound().build());


    }


}
