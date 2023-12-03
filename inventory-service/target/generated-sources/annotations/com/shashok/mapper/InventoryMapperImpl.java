package com.shashok.mapper;

import com.shashok.dto.ProductStockResponse;
import com.shashok.dto.ProductStockResponse.ProductStockResponseBuilder;
import com.shashok.model.Inventory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-03T20:31:05+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public ProductStockResponse toDto(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        ProductStockResponseBuilder productStockResponse = ProductStockResponse.builder();

        productStockResponse.isInStock( checkProductIsStock( inventory ) );
        productStockResponse.productCode( inventory.getProductCode() );

        return productStockResponse.build();
    }
}
