package com.shashok.mapper;

import com.shashok.dto.ProductDto;
import com.shashok.dto.ProductRequestDto;
import com.shashok.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toModel(ProductRequestDto productRequestDto);

    ProductDto toDto(Product product);
}
