package com.example.productervice.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.productervice.dto.ProductDto;
import com.example.productervice.entity.Product;
import com.example.productervice.repo.ProductRepository;
import com.example.productervice.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    
    @Override
    public List<ProductDto> getProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> {
            ProductDto dto = new ProductDto();
            dto.setId(product.getId());
            dto.setProductId(product.getProductId());
            dto.setProductName(product.getProductName());
            dto.setDescription(product.getDescription());
            dto.setForSale(product.getForSale());
            return dto;
        }).collect(Collectors.toList());
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
