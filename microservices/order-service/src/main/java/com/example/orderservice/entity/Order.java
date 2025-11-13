package com.example.orderservice.entity;

import com.example.orderservice.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order {

    @Id
    private int id;
    private int itemId;
    private String orderDate;
    private int amount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
