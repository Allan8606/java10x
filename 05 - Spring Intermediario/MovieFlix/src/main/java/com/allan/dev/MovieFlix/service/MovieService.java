package com.allan.dev.MovieFlix.service;

import com.allan.dev.MovieFlix.controller.request.MovieRequest;
import com.allan.dev.MovieFlix.controller.response.CategoryResponse;
import com.allan.dev.MovieFlix.controller.response.MovieResponse;
import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.entity.Movie;
import com.allan.dev.MovieFlix.entity.Streaming;
import com.allan.dev.MovieFlix.mapper.MovieMapper;
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



    public MovieResponse salvar(MovieRequest movieRequest){

        Movie movie = MovieMapper.paraMovie(movieRequest);
        movie.setCategory(this.buscarCategorias(movie.getCategory()));
        movie.setStreaming(this.buscarStreaming(movie.getStreaming()));

        Movie save = movieRepository.save(movie);
        MovieResponse movieResponse = MovieMapper.paraMovieResponse(save);
        return movieResponse;
    }

    public List<MovieResponse> listarTodos(){
        List<Movie> movies = movieRepository.findAll();
        List<MovieResponse> movieResponses = movies.stream()
                .map(movie -> MovieMapper.paraMovieResponse(movie)).toList();
        return movieResponses;
    }

    private List<Category> buscarCategorias(List<Category> categories){

        List<Category> categoriasEncontradas = new ArrayList<>();
        categories.forEach(category -> {
            categoryService.buscarPorId(category.getId()).ifPresent(categoriasEncontradas::add);
        });
        return categoriasEncontradas;
    }

    private List<Streaming> buscarStreaming(List<Streaming> streamings){

        List<Streaming> streamingsEncontradas = new ArrayList<>();
        streamings.forEach(streaming -> {
            streamingService.buscarPorId(streaming.getId()).ifPresent(streamingsEncontradas::add);
        });
        return streamingsEncontradas;
    }

    public Optional<MovieResponse> buscarPorId(Long id){
         return movieRepository.findById(id)
                .map(MovieMapper::paraMovieResponse);
    }

    public Optional<MovieResponse> atualizar (Long id, MovieRequest movieRequest){
        Optional<Movie> movieEncontrado = movieRepository.findById(id);
        Movie movie = MovieMapper.paraMovie(movieRequest);


        if (movieEncontrado.isPresent()){
            List<Category> categories = this.buscarCategorias(movie.getCategory());
            List<Streaming> streamings = this.buscarStreaming(movie.getStreaming());

            Movie movieAtualizado = movieEncontrado.get();

            movieAtualizado.setTitle(movie.getTitle());
            movieAtualizado.setDescription(movie.getDescription());
            movieAtualizado.setReleaseDate(movie.getReleaseDate());
            movieAtualizado.setRating(movie.getRating());

            //Primeiro limpa a lista antiga para por a nova lista
            movieAtualizado.getCategory().clear();
            movieAtualizado.getCategory().addAll(categories);

            movieAtualizado.getStreaming().clear();
            movieAtualizado.getStreaming().addAll(streamings);

            movieRepository.save(movieAtualizado);
            MovieResponse movieResponse = MovieMapper.paraMovieResponse(movieAtualizado);

            return Optional.of(movieResponse);

        }

        return Optional.empty();
    }

    public List<MovieResponse> buscarPorCategory(Long categoryId){

        List<Movie> movieByCategory = movieRepository.findMovieByCategory(Category.builder().id(categoryId).build());

        return movieByCategory.stream().map(MovieMapper::paraMovieResponse).toList();
    }

    public void deletar(Long id){
        movieRepository.findById(id).map(movie -> {
            movieRepository.deleteById(id);
            return Void.TYPE;
        });

    }






}
