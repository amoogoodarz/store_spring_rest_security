package com.codewithmosh.mystore.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter

@Data
public class ProductDto {

    private String name;
    private String description;
    private BigDecimal price;
    private Byte categoryId;
}
