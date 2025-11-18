package com.example.productervice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productervice.dto.ProductDto;
import com.example.productervice.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
@RequestMapping(value = "api/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("getProducts")
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("product/{id}")
    public ProductDto getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("productId/{id}")
    public Integer getProductIdById(@PathVariable Integer id) {
        return productService.getProductIdById(id);
    }

    @GetMapping("product/byproductid/{productId}")
    public ProductDto getProductByProductId(@PathVariable Integer productId) {
        return productService.getProductByProductId(productId);
    }

    @PostMapping("addProduct")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @PutMapping("updateProduct/{productId}")
    public ProductDto updateProduct(@PathVariable Integer productId, @RequestBody ProductDto productDto) {
        return productService.updateProduct(productId, productDto);
    }

    @DeleteMapping("deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }
}
