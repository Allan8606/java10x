package com.allan.dev.MovieFlix.controller.request;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(String title, String description, LocalDate releaseDate, double rating, List<Long> category, List<Long> streaming) {
}
