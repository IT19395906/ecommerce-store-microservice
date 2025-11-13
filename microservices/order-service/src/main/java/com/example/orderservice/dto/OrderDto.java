package com.example.orderservice.dto;

import com.example.orderservice.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int id;
    private int itemId;
    private String orderDate;
    private int amount;
    private OrderStatus orderStatus = OrderStatus.CREATED;
}
