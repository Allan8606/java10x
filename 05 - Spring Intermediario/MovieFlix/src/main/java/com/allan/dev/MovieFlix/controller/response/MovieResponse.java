package com.allan.dev.MovieFlix.controller.response;


import lombok.Builder;

@Builder
public record MovieResponse(Long id, String name) {
}
