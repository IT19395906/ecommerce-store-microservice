package com.example.productervice.Impl;

import java.time.LocalDateTime;
import java.util.List;
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
            dto.setPrice(product.getPrice());
            dto.setAddedDate(product.getAddedDate());
            dto.setAddedBy(product.getAddedBy());
            dto.setUpdatedDate(product.getUpdatedDate());
            dto.setUpdatedBy(product.getUpdatedBy());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id " + id + " not found"));

        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setForSale(product.getForSale());
        dto.setPrice(product.getPrice());
        dto.setAddedDate(product.getAddedDate());
        dto.setAddedBy(product.getAddedBy());
        dto.setUpdatedDate(product.getUpdatedDate());
        dto.setUpdatedBy(product.getUpdatedBy());
        return dto;
    }

    @Override
    public Integer getProductIdById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Id " + id + " not found"));
        return product.getProductId();
    }

    @Override
    public ProductDto getProductByProductId(Integer productId) {
        Product product = productRepository.getProductByProductId(productId);
        if (product == null) {
            throw new EntityNotFoundException("Product id " + productId + " not found");
        }

        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setForSale(product.getForSale());
        dto.setPrice(product.getPrice());
        dto.setAddedDate(product.getAddedDate());
        dto.setAddedBy(product.getAddedBy());
        dto.setUpdatedDate(product.getUpdatedDate());
        dto.setUpdatedBy(product.getUpdatedBy());
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
        product.setPrice(productDto.getPrice());
        product.setAddedDate(LocalDateTime.now());
        product.setAddedBy("Admin");
        Product savedProduct = productRepository.save(product);

        ProductDto dto = new ProductDto();
        dto.setId(savedProduct.getId());
        dto.setProductId(savedProduct.getProductId());
        dto.setProductName(savedProduct.getProductName());
        dto.setDescription(savedProduct.getDescription());
        dto.setForSale(savedProduct.getForSale());
        dto.setPrice(savedProduct.getPrice());
        dto.setAddedDate(savedProduct.getAddedDate());
        dto.setAddedBy(savedProduct.getAddedBy());
        dto.setUpdatedDate(savedProduct.getUpdatedDate());
        dto.setUpdatedBy(savedProduct.getUpdatedBy());
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
        existing.setPrice(productDto.getPrice());
        existing.setUpdatedDate(LocalDateTime.now());
        existing.setUpdatedBy("Admin");
        Product updatedProduct = productRepository.save(existing);

        ProductDto dto = new ProductDto();
        dto.setId(updatedProduct.getId());
        dto.setProductId(updatedProduct.getProductId());
        dto.setProductName(updatedProduct.getProductName());
        dto.setDescription(updatedProduct.getDescription());
        dto.setForSale(updatedProduct.getForSale());
        dto.setPrice(updatedProduct.getPrice());
        dto.setAddedDate(updatedProduct.getAddedDate());
        dto.setAddedBy(updatedProduct.getAddedBy());
        dto.setUpdatedDate(updatedProduct.getUpdatedDate());
        dto.setUpdatedBy(updatedProduct.getUpdatedBy());
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
