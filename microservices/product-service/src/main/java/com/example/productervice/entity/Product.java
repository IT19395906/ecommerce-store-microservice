package com.example.productervice.entity;

import jakarta.persistence.Id;

public class Product {

    @Id
    private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;
}
