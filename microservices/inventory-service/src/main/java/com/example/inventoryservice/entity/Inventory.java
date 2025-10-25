package com.example.inventoryservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Inventory {

    @Id
    private int id;
    private int itemId;
    private int productId;
    private int quantity;
}
