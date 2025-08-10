package com.amoogoodarz.store.mappers;

import com.amoogoodarz.store.dtos.product.ProductDto;
import com.amoogoodarz.store.entities.Product;
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
