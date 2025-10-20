package com.allan.dev.MovieFlix.service;


import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Optional<Category> buscarPorId(Long id){
        return categoryRepository.findById(id);
    }

    public void deletarCategoriaPorId(Long id){
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }

    }





}
