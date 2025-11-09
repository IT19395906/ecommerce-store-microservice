package com.example.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.CommonResponseDto;
import com.example.orderservice.Impl.Producer;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.service.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping(value = "api/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Producer producer;

    @GetMapping("getOrders")
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("order/{orderId}")
    public OrderDto getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping("addOrder")
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        OrderDto order = orderService.addOrder(orderDto);
        producer.sendMessage(new CommonResponseDto("message sent to kafka saying new order created", "CREATED", order.getId()));
        return order;
    }

    @PutMapping("updateOrder/{orderId}")
    public OrderDto updateOrder(@PathVariable Integer orderId, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(orderId, orderDto);
    }

    @DeleteMapping("deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteOrder(orderId);
    }

}
