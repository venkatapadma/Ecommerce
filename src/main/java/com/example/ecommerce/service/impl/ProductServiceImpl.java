package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CreateProductRequest;
import com.example.ecommerce.dto.UpdateProductRequest;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repo.ProductRepo;
import com.example.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Iterable<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public Product insertProduct(CreateProductRequest requestDto) {
        Product product = new Product();
        product.setName(requestDto.name());
        product.setPrice(requestDto.price());
        product.setQuantity(requestDto.quantity());
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(UpdateProductRequest requestDto) {

        Product product = productRepo.findById(requestDto.id()).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(requestDto.name());
        product.setPrice(requestDto.price());
        product.setQuantity(requestDto.quantity());
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepo.delete(product);
    }
}
