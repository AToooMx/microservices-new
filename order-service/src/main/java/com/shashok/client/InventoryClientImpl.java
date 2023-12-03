package com.shashok.client;

import com.shashok.dto.IsStockResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InventoryClientImpl implements InventoryClient{
    private final WebClient webClient;
    @Override
    public List<IsStockResponse> productIsStock(List<String> productCode) {
        log.info("Request to check product is stoke in inventory by product code={}", productCode);
        List<IsStockResponse> response = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/inventory/products/is-in-stock")
                        .queryParam("productsCode", productCode)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<IsStockResponse>>() {})
                .block();
        log.info("WebClient response {}", response);
        return response;
    }

    //( "/api/v1/inventory/products/is-in-stock")
}
