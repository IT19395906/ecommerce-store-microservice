package com.example.productervice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;
}
