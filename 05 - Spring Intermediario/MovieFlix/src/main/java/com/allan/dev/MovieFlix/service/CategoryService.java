package com.allan.dev.MovieFlix.service;


import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> listarTodasCategorias(){
        return categoryRepository.findAll();
    }



    public Category salvarCategoria(Category category){
        return categoryRepository.save(category);
    }





}
