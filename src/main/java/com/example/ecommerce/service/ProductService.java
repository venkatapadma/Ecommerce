package com.example.ecommerce.service;

import com.example.ecommerce.dto.CreateProductRequest;
import com.example.ecommerce.dto.UpdateProductRequest;
import com.example.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    Iterable<Product> getAllProducts();

    List<Product> getProductByName(String name);

    Product insertProduct(CreateProductRequest requestDto);

    Product updateProduct(UpdateProductRequest requestDto);

    void deleteProduct(String id);
}
