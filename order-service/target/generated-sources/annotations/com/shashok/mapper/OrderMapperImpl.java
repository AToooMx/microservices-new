package com.shashok.mapper;

import com.shashok.dto.OrderItemsDto;
import com.shashok.dto.OrderRequest;
import com.shashok.model.Order;
import com.shashok.model.Order.OrderBuilder;
import com.shashok.model.OrderItems;
import com.shashok.model.OrderItems.OrderItemsBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-03T20:49:08+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toModel(OrderRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderBuilder order = Order.builder();

        order.orderNumber( getOrderNumber( request ) );
        order.orderItems( orderItemsDtoListToOrderItemsList( request.getOrderItems() ) );

        return order.build();
    }

    protected OrderItems orderItemsDtoToOrderItems(OrderItemsDto orderItemsDto) {
        if ( orderItemsDto == null ) {
            return null;
        }

        OrderItemsBuilder orderItems = OrderItems.builder();

        orderItems.id( orderItemsDto.getId() );
        orderItems.productCode( orderItemsDto.getProductCode() );
        orderItems.price( orderItemsDto.getPrice() );
        orderItems.quantity( orderItemsDto.getQuantity() );

        return orderItems.build();
    }

    protected List<OrderItems> orderItemsDtoListToOrderItemsList(List<OrderItemsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItems> list1 = new ArrayList<OrderItems>( list.size() );
        for ( OrderItemsDto orderItemsDto : list ) {
            list1.add( orderItemsDtoToOrderItems( orderItemsDto ) );
        }

        return list1;
    }
}
