package com.codewithmosh.mystore.dtos.cart;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CartItemDto {
    private CartProductDto product;
    private int quantity;
    private BigDecimal totalPrice;

}
