package com.example.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "product_index")
public class ProductSearchDocument {

    @Id
    private String id;

    private String name;

    private BigDecimal price;


    public static ProductSearchDocument fromProduct(Product product) {
        ProductSearchDocument searchDocument = new ProductSearchDocument();
        searchDocument.setId(product.getId());
        searchDocument.setName(product.getName());
        searchDocument.setPrice(product.getPrice());
        return searchDocument;
    }
}
