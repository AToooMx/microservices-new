package com.shashok.service;

import com.shashok.dto.OrderRequest;
import com.shashok.model.Order;

import java.util.List;

public interface OrderService {
    String placeOrder(OrderRequest request);

    List<Order> getOrderList();
}
