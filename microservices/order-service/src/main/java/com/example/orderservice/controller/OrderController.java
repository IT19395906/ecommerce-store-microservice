package com.example.orderservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.service.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping(value = "api/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("getOrders")
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("order/{orderId}")
    public OrderDto getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

}
