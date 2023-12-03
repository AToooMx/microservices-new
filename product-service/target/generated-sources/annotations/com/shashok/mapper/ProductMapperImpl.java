package com.shashok.mapper;

import com.shashok.dto.ProductDto;
import com.shashok.dto.ProductDto.ProductDtoBuilder;
import com.shashok.dto.ProductRequestDto;
import com.shashok.model.Product;
import com.shashok.model.Product.ProductBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-03T21:41:27+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toModel(ProductRequestDto productRequestDto) {
        if ( productRequestDto == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.name( productRequestDto.getName() );
        product.description( productRequestDto.getDescription() );
        product.price( productRequestDto.getPrice() );

        return product.build();
    }

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDtoBuilder productDto = ProductDto.builder();

        productDto.id( product.getId() );
        productDto.name( product.getName() );
        productDto.description( product.getDescription() );
        productDto.price( product.getPrice() );

        return productDto.build();
    }
}
