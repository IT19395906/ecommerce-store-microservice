package com.example.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Order {

    @Id
    private int id;
    private int itemId;
    private String orderDate;
    private int amount;

}
