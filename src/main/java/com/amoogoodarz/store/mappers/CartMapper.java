package com.amoogoodarz.store.mappers;

import com.amoogoodarz.store.dtos.cart.CartDto;
import com.amoogoodarz.store.dtos.cart.CartItemDto;
import com.amoogoodarz.store.entities.Cart;
import com.amoogoodarz.store.entities.CartItem;
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
