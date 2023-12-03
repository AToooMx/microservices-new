package com.shashok.client;

import com.shashok.dto.IsStockResponse;

import java.util.List;

public interface InventoryClient {

    List<IsStockResponse> productIsStock(List<String> productCode);
}
