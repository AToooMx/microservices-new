package com.shashok.dao;

import com.shashok.model.OrderItems;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderListRepository extends MongoRepository<OrderItems, String> {
}
