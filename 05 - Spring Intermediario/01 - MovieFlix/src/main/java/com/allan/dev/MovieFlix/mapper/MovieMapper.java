package com.allan.dev.MovieFlix.mapper;



import com.allan.dev.MovieFlix.controller.request.MovieRequest;
import com.allan.dev.MovieFlix.controller.response.CategoryResponse;
import com.allan.dev.MovieFlix.controller.response.MovieResponse;
import com.allan.dev.MovieFlix.controller.response.StreamingResponse;
import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.entity.Movie;
import com.allan.dev.MovieFlix.entity.Streaming;
import lombok.experimental.UtilityClass;
import java.util.List;

@UtilityClass
public class MovieMapper {



    public static Movie paraMovie(MovieRequest movieRequest){

        List<Category> listCategories = movieRequest.category()
                .stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> listStreaming = movieRequest.streaming().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();



        return Movie
                .builder()
                .title(movieRequest.title())
                .description(movieRequest.description())
                .releaseDate(movieRequest.releaseDate())
                .rating(movieRequest.rating())
                .category(listCategories)
                .streaming(listStreaming)
                .build();
    }

    public static MovieResponse paraMovieResponse(Movie movie) {
        List<CategoryResponse> categories = movie.getCategory()
                .stream()
                .map(category -> CategoryMapper.paraCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamingList = movie.getStreaming()
                .stream()
                .map(streaming -> StreamingMapper.paraStreamingResponse(streaming))
                .toList();



        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .categories(categories)
                .streaming(streamingList)
                .build();
    }


}
