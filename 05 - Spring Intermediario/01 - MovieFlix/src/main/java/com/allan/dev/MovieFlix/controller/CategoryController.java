package com.allan.dev.MovieFlix.controller;


import com.allan.dev.MovieFlix.controller.request.CategoryRequest;
import com.allan.dev.MovieFlix.controller.response.CategoryResponse;
import com.allan.dev.MovieFlix.entity.Category;
import com.allan.dev.MovieFlix.mapper.CategoryMapper;
import com.allan.dev.MovieFlix.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
@Tag(name = "Category", description = "Recurso responsável pelo gerenciamento das categorias dos filmes")
public class CategoryController {

    private final CategoryService categoryService;


    @Operation(summary = "Cria categoria", description = "Método responsável por criar uma nova categoria", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Categoria salva com sucesso", content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        Category category = CategoryMapper.paraCategoria(request);
        Category savedCategory = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.paraCategoryResponse(savedCategory));
    }


    @Operation(summary = "Lista todas as categorias cadastradas", description = "Método responsável por listar todas as categorias cadastradas", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todas as categorias", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class))))
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll() {
        List<CategoryResponse> categories = categoryService.findAll().stream()
                .map(CategoryMapper::paraCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }


    @Operation(summary = "Busca por ID da categoria", description = "Método responsável por buscar categoria pelo seu ID", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso", content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada", content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> find(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.paraCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(summary = "Deleta categoria", description = "Método responsável por deletar uma categoria cadastrada", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categoria deletado com sucesso", content = @Content())
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada", content = @Content())
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            categoryService.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
