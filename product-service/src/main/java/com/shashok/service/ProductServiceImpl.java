package com.shashok.service;

import com.shashok.dao.ProductRepository;
import com.shashok.dto.ProductDto;
import com.shashok.dto.ProductRequestDto;
import com.shashok.exception.NotFoundException;
import com.shashok.mapper.ProductMapper;
import com.shashok.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Product createProduct(ProductRequestDto request){
        Product product = productRepository.insert(productMapper.toModel(request));
        log.info("Product: {} is saved", product);
        return product;
    }

    @Override
    public List<ProductDto> getProductList() {
        List<Product> products= productRepository.findAll();
        if(products.isEmpty()){
            log.error("Products not found");
            throw new NotFoundException("Products not found");
        }
        log.info("ProductServiceImpl.getProductList(): product size {}", products.size());
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
}
