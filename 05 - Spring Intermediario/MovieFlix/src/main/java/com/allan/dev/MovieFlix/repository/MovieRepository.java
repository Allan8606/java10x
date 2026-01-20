package com.allan.dev.MovieFlix.repository;

import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findMovieByCategory(List<Category> categories);
}
