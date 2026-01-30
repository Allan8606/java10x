package dev.java.ecommerce.basketservice.service;


import dev.java.ecommerce.basketservice.client.PlatziStoreClient;
import dev.java.ecommerce.basketservice.client.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductResponse> buscarTodosProdutos(){
        return platziStoreClient.buscarTodosProdutos();
    }

    @Cacheable(value = "products", key = "#productId")
    public PlatziProductResponse buscarPorId(Long productId){
        return platziStoreClient.buscarPorId(productId);
    }

}
