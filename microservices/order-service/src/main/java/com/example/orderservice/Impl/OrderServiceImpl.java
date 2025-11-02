package com.example.orderservice.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.Order;
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

    private OrderDto convertToDto(Order order){
        OrderDto dto = new OrderDto();
            dto.setId(order.getId());
            dto.setItemId(order.getItemId());
            dto.setAmount(order.getAmount());
            dto.setOrderDate(order.getOrderDate());
            return dto;
    }

    private Order convertToEntity(OrderDto orderDto){
        Order entity = new Order();
        entity.setId(orderDto.getId());
        entity.setItemId(orderDto.getItemId());
        entity.setAmount(orderDto.getAmount());
        entity.setOrderDate(orderDto.getOrderDate());
        return entity;
    }

}
