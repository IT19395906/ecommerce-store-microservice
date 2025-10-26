package com.example.productervice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Product {

    @Id
    private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;
}
