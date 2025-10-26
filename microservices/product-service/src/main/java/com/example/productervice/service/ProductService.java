package com.example.productervice.service;

import java.util.List;

import com.example.productervice.dto.ProductDto;

public interface ProductService {

    List<ProductDto> getProducts();

    ProductDto getProductById(Integer productId);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(Integer productId, ProductDto productDto);

    String deleteProduct(Integer productId);
}
