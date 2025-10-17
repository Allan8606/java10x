package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.controller.request.CategoryRequest;
import com.allan.dev.MovieFlix.controller.response.CategoryResponse;
import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.mapper.CategoryMapper;
import com.allan.dev.MovieFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<CategoryResponse> listarTodasCategorias(){
        List<Category> listaCategory = categoryService.listarTodasCategorias();
        return listaCategory.stream()
                .map(CategoryMapper::paraCategoryResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryResponse buscarPorId(@PathVariable Long id){
        return categoryService.buscarPorId(id);
    }

    @PostMapping()
    public CategoryResponse salvarCategoria(@RequestBody CategoryRequest request){
        return categoryService.salvarCategoria(category);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id){
        categoryService.deletarCategoriaPorId(id);
    }




}
