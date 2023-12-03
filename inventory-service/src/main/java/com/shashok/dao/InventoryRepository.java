package com.shashok.dao;

import com.shashok.dto.ProductStockResponse;
import com.shashok.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

    List<Inventory> findByProductCodeIn(List<String> productCode);

}
