package com.shashok.service;

import com.shashok.dto.ProductStockResponse;

import java.util.List;

public interface InventoryService {

    List<ProductStockResponse> isInStockByProductCode(List<String> productCode);
}
