package com.example.productervice.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.productervice.dto.ProductDto;
import com.example.productervice.entity.Product;
import com.example.productervice.repo.ProductRepository;
import com.example.productervice.service.ProductService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

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
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product id " + productId + " not found"));

        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setForSale(product.getForSale());
        return dto;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setForSale(productDto.getForSale());
        productRepository.save(product);
        return productDto;
    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto) {
        Product existing = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product id " + productId + " not found"));
        existing.setProductId(productDto.getProductId());
        existing.setProductName(productDto.getProductName());
        existing.setDescription(productDto.getDescription());
        existing.setForSale(productDto.getForSale());
        productRepository.save(existing);
        return productDto;
    }

    @Override
    public String deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
        return "Successfully deleted";
    }

}
