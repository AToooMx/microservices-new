package com.shashok.controller;

import com.shashok.dto.ProductDto;
import com.shashok.dto.ProductRequestDto;
import com.shashok.model.Product;
import com.shashok.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody ProductRequestDto request){
        log.info("Request for save product in DB: request = {}", request);
        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        log.info("Request for get all products in DB");
        return productService.getProductList();
    }

}
