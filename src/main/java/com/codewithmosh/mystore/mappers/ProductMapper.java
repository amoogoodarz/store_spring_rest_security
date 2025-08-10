package com.codewithmosh.mystore.mappers;

import com.codewithmosh.mystore.dtos.product.ProductDto;
import com.codewithmosh.mystore.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
    void updateEntity(ProductDto productDto, @MappingTarget Product product);
}
