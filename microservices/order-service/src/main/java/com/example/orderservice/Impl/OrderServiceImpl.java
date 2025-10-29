package com.example.orderservice.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<OrderDto> getOrders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrders'");
    }

    @Override
    public OrderDto getOrderById(Integer orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderById'");
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addOrder'");
    }

    @Override
    public OrderDto updateOrder(Integer orderId, OrderDto orderDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
    }

    @Override
    public String deleteOrder(Integer orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOrder'");
    }

}
