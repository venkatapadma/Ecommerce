package com.example.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String name;

    private BigDecimal price;

    private Integer quantity;
}
