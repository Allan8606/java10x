package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.controller.request.CategoryRequest;
import com.allan.dev.MovieFlix.controller.response.CategoryResponse;
import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.mapper.CategoryMapper;
import com.allan.dev.MovieFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> listarTodasCategorias(){
        List<Category> listaCategory = categoryService.listarTodasCategorias();
        List<CategoryResponse> lista = listaCategory.stream()
                .map(CategoryMapper::paraCategoryResponse)
                .toList();

        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> buscarPorId(@PathVariable Long id){
        return categoryService.buscarPorId(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.paraCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());


    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> salvarCategoria(@RequestBody CategoryRequest request){
        Category novaCategoria = CategoryMapper.paraCategoria(request);
        Category salvarCategoria = categoryService.salvarCategoria(novaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.paraCategoryResponse(salvarCategoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        categoryService.deletarCategoriaPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> atualizar(@PathVariable Long id, @RequestBody CategoryRequest request){

      return categoryService.atualizar(id, request)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
    }




}
