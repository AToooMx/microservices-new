package com.shashok.service;

import com.shashok.client.InventoryClient;
import com.shashok.dao.OrderListRepository;
import com.shashok.dao.OrderRepository;
import com.shashok.dto.IsStockResponse;
import com.shashok.dto.OrderItemsDto;
import com.shashok.dto.OrderRequest;
import com.shashok.mapper.OrderMapper;
import com.shashok.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderListRepository orderListRepository;
    private final InventoryClient inventoryClient;

    @Override
    public String placeOrder(OrderRequest request) {
        List<String> productsCode = request.getOrderItems().stream()
                        .map(OrderItemsDto::getProductCode)
                        .toList();
        List<IsStockResponse> responses = inventoryClient.productIsStock(productsCode);
        boolean allProductsIsInStock = responses.stream().allMatch(IsStockResponse::isInStock);
        if(allProductsIsInStock) {
            Order order = orderMapper.toModel(request);
            orderListRepository.insert(order.getOrderItems());
            Order saveOrder = orderRepository.insert(order);
            log.info("Save order successfully: order={}", saveOrder);
            return saveOrder.getId();
        }else{
            List<String> productsCodeNotAvailable = responses.stream()
                            .filter(isStockResponse -> !isStockResponse.isInStock())
                            .map(IsStockResponse::getProductCode)
                            .toList();
            log.info("Product with code={} not is stock", productsCodeNotAvailable);
            throw new IllegalArgumentException("Product with productCode=" + productsCodeNotAvailable + "not is stock");
        }
    }

    @Override
    public List<Order> getOrderList() {
        List<Order> orders = orderRepository.findAll();
        log.info("Find orders size={}", orders.size());
        return orders;
    }
}
