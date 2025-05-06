package com.app.product.controller;

import com.app.product.exceptions.DuplicateKeyException;
import com.app.product.exceptions.InvalidInputException;
import com.app.product.exceptions.NotFoundException;
import com.app.product.model.Product;
import com.app.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Level;

@RestController
@RequestMapping(value="/api")
public class ProductController {

    private final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping(value="/product/{id}")
    public Mono<Product> productById(@PathVariable("id") Integer id){
        return this.productService.getProductById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Producto no encontrado con id: " + id)))
                .log(LOG.getName(), Level.FINE);
    }

    @GetMapping(value="/product")
    public Flux<Product> allProduct(){
        return this.productService.getProducts()
                .log(LOG.getName(), Level.FINE);
    }

    @DeleteMapping(value="/product/{id}")
    public Mono<Void> deleteProduct(@PathVariable("id") Integer id){
        if(id < 1) throw new InvalidInputException("Invalid product id: " + id);
        return this.productService.getProductById(id)
                .map(this.productService::delete)
                .flatMap(e -> e);
    }

    @PostMapping(value="/product")
    public Mono<Product> createProduct(@RequestBody Product product){
        return this.productService.createProduct(product)
                .log(LOG.getName(), Level.FINE)
                .onErrorMap(
                        DuplicateKeyException.class,
                        ex -> new DuplicateKeyException("Producto duplciado con el id: " + product.getId())
                );
    }
}
