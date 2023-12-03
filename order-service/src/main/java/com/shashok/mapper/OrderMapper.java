package com.shashok.mapper;

import com.shashok.dto.OrderRequest;
import com.shashok.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = ".", qualifiedByName = "orderNumber", target = "orderNumber")
    Order toModel(OrderRequest request);

    @Named("orderNumber")
    default String getOrderNumber(OrderRequest request){
        return UUID.randomUUID().toString();
    }
}
