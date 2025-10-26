package com.example.productervice.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.productervice.dto.ProductDto;
import com.example.productervice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public List<ProductDto> getProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProducts'");
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public String deleteProduct(Integer productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

}
