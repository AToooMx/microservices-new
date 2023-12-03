package com.shashok.mapper;

import com.shashok.dto.ProductStockResponse;
import com.shashok.model.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    @Mapping(source = ".", qualifiedByName = "isInStock", target = "isInStock")
    ProductStockResponse toDto(Inventory inventory);

    @Named("isInStock")
    default boolean checkProductIsStock(Inventory inventory){
        return inventory.getQuantity() > 0;
    }

}
