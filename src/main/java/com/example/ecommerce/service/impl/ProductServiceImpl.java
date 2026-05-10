package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CreateProductRequest;
import com.example.ecommerce.dto.UpdateProductRequest;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.ProductSearchDocument;
import com.example.ecommerce.repo.ProductRepo;
import com.example.ecommerce.repo.ProductSearchRepo;
import com.example.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductSearchRepo productSearchRepo;

    public ProductServiceImpl(ProductRepo productRepo, ProductSearchRepo productSearchRepo) {
        this.productRepo = productRepo;
        this.productSearchRepo = productSearchRepo;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<ProductSearchDocument> getProductByName(String name) {
        return productSearchRepo.findByName(name);
    }

    @Override
    public Product insertProduct(CreateProductRequest requestDto) {
        Product product = new Product();
        product.setName(requestDto.name());
        product.setPrice(requestDto.price());
        product.setQuantity(requestDto.quantity());
        Product savedProduct = productRepo.save(product);

        //index to Elasticsearch
        ProductSearchDocument searchDocument = ProductSearchDocument.fromProduct(product);
        productSearchRepo.save(searchDocument);

        return savedProduct;
    }

    @Override
    public Product updateProduct(UpdateProductRequest requestDto) {

        Product product = productRepo.findById(requestDto.id()).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(requestDto.name());
        product.setPrice(requestDto.price());
        product.setQuantity(requestDto.quantity());
        Product updatedProduct = productRepo.save(product);

        ProductSearchDocument searchDocument = ProductSearchDocument.fromProduct(product);
        productSearchRepo.save(searchDocument);

        return updatedProduct;
    }

    @Override
    public void deleteProduct(String id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        productRepo.delete(product);

        productSearchRepo.deleteById(product.getId());
    }
}
