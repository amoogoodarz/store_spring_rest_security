package com.amoogoodarz.store.mappers;

import com.amoogoodarz.store.dtos.order.OrderDto;
import com.amoogoodarz.store.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
}
