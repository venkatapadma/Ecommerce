package com.example.ecommerce.repo;

import com.example.ecommerce.entity.ProductSearchDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSearchRepo extends ElasticsearchRepository<ProductSearchDocument, String> {

    List<ProductSearchDocument> findByName(String name);
}
