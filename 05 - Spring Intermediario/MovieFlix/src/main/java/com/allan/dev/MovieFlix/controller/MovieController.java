package com.allan.dev.MovieFlix.controller;

import com.allan.dev.MovieFlix.controller.request.MovieRequest;
import com.allan.dev.MovieFlix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public void savar(@RequestBody MovieRequest request){

    }
}
