package com.app.product.service;

import com.app.product.model.Product;
import com.app.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public Flux<Product> getProducts(){
        return Flux.fromIterable(this.repository.getProducts());
    }

    @Override
    public Mono<Product> getProductById(Integer id) {
        Product product = this.repository.getProduct(id);
        return Mono.justOrEmpty(product);
    }

    @Override
    public Mono<Void> delete(Product product){
        this.repository.productDelete(product.getId());
        return Mono.empty();
    }

    @Override
    public Mono<Product> createProduct(Product product){
        return Mono.just(this.repository.createProduct(product));
    }


}
