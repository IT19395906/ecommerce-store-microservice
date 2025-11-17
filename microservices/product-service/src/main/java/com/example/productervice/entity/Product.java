package com.example.productervice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private BigDecimal price;
    private LocalDateTime addedDate;
    private String addedBy;
    private LocalDateTime updatedDate;
    private String updatedBy;
}
