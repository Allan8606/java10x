package dev.java.ecommerce.basketservice.client;


import dev.java.ecommerce.basketservice.client.response.PlatziProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PlatziStoreClient", url = "${basket.client.platzi}")
public interface PlatziStoreClient {


    @GetMapping("/products")
    public List<PlatziProductResponse> buscarTodosProdutos();

    @GetMapping("/products/{id}")
    public PlatziProductResponse buscarPorId(@PathVariable Long id);


}
