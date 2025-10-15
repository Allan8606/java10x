package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.entity.Category;
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
    public List<Category> listarTodasCategorias(){
        return  categoryService.listarTodasCategorias();
    }

    @PostMapping()
    public Category salvarCategoria(@RequestBody Category category){
        return categoryService.salvarCategoria(category);
    }


}
