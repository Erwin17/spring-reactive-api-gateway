package com.app.product.repository;

import com.app.product.exceptions.DuplicateKeyException;
import com.app.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository {
    private final ConcurrentHashMap<Integer, Product> productsMap =  new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(0);

    public ProductRepository(){
        productAdd(new Product(null, "Producto-1", "Description-1", 100.00));
        productAdd(new Product(null, "Producto-2", "Description-2", 44.00));
        productAdd(new Product(null, "Producto-3", "Description-3", 35.00));
        productAdd(new Product(null, "Producto-4", "Description-4", 99.99));
        productAdd(new Product(null, "Producto-5", "Description-5", 134.50));
    }

    public List<Product> getProducts(){
        return this.productsMap.values().stream().toList();
    }

    public Product getProduct(Integer id){
        return productsMap.get(id);
    }

    public void productDelete(Integer id){
        productsMap.remove(id);
    }

    public Product createProduct(Product product){
        if(getProduct(product.getId()) != null) throw new DuplicateKeyException();
        return productAdd(product);
    }

    private Product productAdd(Product product){
        int id = idGenerator.getAndIncrement();
        product.setId(id);
        productsMap.put(id, product);
        return product;
    }
}
