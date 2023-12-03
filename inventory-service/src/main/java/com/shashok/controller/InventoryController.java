package com.shashok.controller;

import com.shashok.dto.ProductStockResponse;
import com.shashok.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping(value = "/products/is-in-stock", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductStockResponse> isInStock(@RequestParam("productsCode") List<String> productCode){
        log.info("Request check is in stock inventory: productsCode={}", productCode);
        return inventoryService.isInStockByProductCode(productCode);
    }
}
