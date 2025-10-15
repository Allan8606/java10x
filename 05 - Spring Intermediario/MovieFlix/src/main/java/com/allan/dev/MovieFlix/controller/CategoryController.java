package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
