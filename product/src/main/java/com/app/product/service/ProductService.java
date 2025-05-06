package com.app.product.service;

import com.app.product.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductService {
    public Flux<Product> getProducts();
    public Mono<Product> getProductById(Integer id);
    public Mono<Void> delete(Product product);
    public Mono<Product> createProduct(Product product);
}
