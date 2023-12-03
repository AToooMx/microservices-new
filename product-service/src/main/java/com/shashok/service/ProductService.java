package com.shashok.service;

import com.shashok.dto.ProductDto;
import com.shashok.dto.ProductRequestDto;
import com.shashok.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequestDto request);

    List<ProductDto> getProductList();
}
