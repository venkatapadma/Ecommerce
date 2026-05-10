package com.example.ecommerce.repo;

import com.example.ecommerce.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ElasticsearchRepository<Product,String> {

    List<Product> findByName(String name);
}
