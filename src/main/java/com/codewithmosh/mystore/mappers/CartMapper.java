package com.codewithmosh.mystore.mappers;

import com.codewithmosh.mystore.dtos.cart.CartDto;
import com.codewithmosh.mystore.dtos.cart.CartItemDto;
import com.codewithmosh.mystore.entities.Cart;
import com.codewithmosh.mystore.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "totalPrice", expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);
    Cart toEntity(CartDto cartDto);
    @Mapping(target = "totalPrice", expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);

}
