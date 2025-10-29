package com.example.orderservice.service;

import java.util.List;

import com.example.orderservice.dto.OrderDto;

public interface OrderService {

    List<OrderDto> getOrders();

    OrderDto getOrderById(Integer orderId);

    OrderDto addOrder(OrderDto orderDto);

    OrderDto updateOrder(Integer orderId, OrderDto orderDto);

    String deleteOrder(Integer orderId);
}
