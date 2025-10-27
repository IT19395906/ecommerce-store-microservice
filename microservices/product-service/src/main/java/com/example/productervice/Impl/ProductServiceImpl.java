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
        Product savedProduct = productRepository.save(product);

        ProductDto dto = new ProductDto();
        dto.setId(savedProduct.getId());
        dto.setProductId(savedProduct.getProductId());
        dto.setProductName(savedProduct.getProductName());
        dto.setDescription(savedProduct.getDescription());
        dto.setForSale(savedProduct.getForSale());
        return dto;
    }

    @Override
    public ProductDto updateProduct(Integer productId, ProductDto productDto) {
        Product existing = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product id " + productId + " not found"));
        existing.setProductId(productDto.getProductId());
        existing.setProductName(productDto.getProductName());
        existing.setDescription(productDto.getDescription());
        existing.setForSale(productDto.getForSale());
        Product updatedProduct = productRepository.save(existing);

        ProductDto dto = new ProductDto();
        dto.setId(updatedProduct.getId());
        dto.setProductId(updatedProduct.getProductId());
        dto.setProductName(updatedProduct.getProductName());
        dto.setDescription(updatedProduct.getDescription());
        dto.setForSale(updatedProduct.getForSale());
        return dto;
    }

    @Override
    public String deleteProduct(Integer productId) {
        if (!productRepository.existsById(productId)) {
            throw new EntityNotFoundException("Product id " + productId + " not found");
        }
        productRepository.deleteById(productId);
        return "Successfully deleted";
    }

}
