package dev.java.ecommerce.basketservice.controller;

import dev.java.ecommerce.basketservice.client.response.PlatziProductResponse;
import dev.java.ecommerce.basketservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<PlatziProductResponse>> buscarTodosProdutos(){
        List<PlatziProductResponse> platziProductResponses = productService.buscarTodosProdutos();
        return ResponseEntity.ok(platziProductResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatziProductResponse> buscarPorID(@PathVariable Long id){
        PlatziProductResponse platziProductResponse = productService.buscarPorId(id);
        return ResponseEntity.ok(platziProductResponse);
    }

}
