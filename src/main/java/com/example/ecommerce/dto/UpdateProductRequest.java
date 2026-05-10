package com.example.ecommerce.dto;

import java.math.BigDecimal;

public record UpdateProductRequest(String id, String name, BigDecimal price, Integer quantity) {
}
