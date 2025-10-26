package com.example.productervice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productervice.dto.ProductDto;
import com.example.productervice.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;

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
    
}
