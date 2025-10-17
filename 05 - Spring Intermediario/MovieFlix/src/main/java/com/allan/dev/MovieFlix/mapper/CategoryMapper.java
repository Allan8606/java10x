package com.allan.dev.MovieFlix.mapper;

import com.allan.dev.MovieFlix.controller.request.CategoryRequest;
import com.allan.dev.MovieFlix.controller.response.CategoryResponse;
import com.allan.dev.MovieFlix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category paraCategoria(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse paraCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
