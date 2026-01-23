package com.allan.dev.MovieFlix.service;

import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.entity.Movie;
import com.allan.dev.MovieFlix.entity.Streaming;
import com.allan.dev.MovieFlix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> findByCategory(Long categoryId) {
        return movieRepository.findMovieByCategory(List.of(Category.builder().id(categoryId).build()));
    }

    public Movie save(Movie newMovie) {
        newMovie.setCategory(findCategories(newMovie.getCategory()));
        newMovie.setStreaming(findServices(newMovie.getStreaming()));
        return movieRepository.save(newMovie);
    }

    public Optional<Movie> update(Long id, Movie updateMovie) {
        Optional<Movie> optMovie = findById(id);
        if (optMovie.isPresent()) {
            Movie movie = optMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setRating(updateMovie.getRating());
            movie.setReleaseDate(updateMovie.getReleaseDate());

            movie.getCategory().clear();
            movie.getCategory().addAll(findCategories(updateMovie.getCategory()));

            movie.getStreaming().clear();
            movie.getStreaming().addAll(findServices(updateMovie.getStreaming()));

            return Optional.of(movieRepository.save(movie));
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesList = new ArrayList<>();
        categories.forEach(category -> {
            Optional<Category> optCategory = categoryService.findById(category.getId());
            optCategory.ifPresent(categoriesList::add);
        });
        return categoriesList;
    }

    private List<Streaming> findServices(List<Streaming> streamings) {
        List<Streaming> servicesList = new ArrayList<>();
        streamings.forEach(s -> {
            Optional<Streaming> optStreamService = streamingService.findById(s.getId());
            optStreamService.ifPresent(servicesList::add);
        });
        return servicesList;
    }






}
