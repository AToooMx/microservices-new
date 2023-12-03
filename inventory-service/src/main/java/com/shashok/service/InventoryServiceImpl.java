package com.shashok.service;

import com.shashok.dao.InventoryRepository;
import com.shashok.dto.ProductStockResponse;
import com.shashok.mapper.InventoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;
    @Override
    public List<ProductStockResponse> isInStockByProductCode(List<String> productCode) {
        var response = inventoryRepository.findByProductCodeIn(productCode).stream()
                .map(inventoryMapper::toDto)
                .toList();
        log.info("Response from DB={}", response);
        return response;
    }
}
