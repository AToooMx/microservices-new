package com.shashok.service;

import com.shashok.dao.OrderListRepository;
import com.shashok.dao.OrderRepository;
import com.shashok.dto.OrderRequest;
import com.shashok.mapper.OrderMapper;
import com.shashok.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderListRepository orderListRepository;

    @Override
    public String placeOrder(OrderRequest request) {
        Order order = orderMapper.toModel(request);
        orderListRepository.insert(order.getOrderItems());
        Order saveOrder = orderRepository.insert(order);
        log.info("Save order successfully: order={}", saveOrder);
        return saveOrder.getId();
    }

    @Override
    public List<Order> getOrderList() {
        List<Order> orders = orderRepository.findAll();
        log.info("Find orders size={}", orders.size());
        return orders;
    }
}
