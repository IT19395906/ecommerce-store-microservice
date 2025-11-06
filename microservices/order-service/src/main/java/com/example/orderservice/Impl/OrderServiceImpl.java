package com.example.orderservice.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.inventoryservice.dto.InventoryDto;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repo.OrderRepository;
import com.example.orderservice.service.OrderService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    private final WebClient webClient;

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order id " + orderId + " not found"));
        return convertToDto(order);
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Integer itemId = orderDto.getItemId();
        try {
            webClient.get().uri("http://localhost:8080/api/inventory/item/{itemId}", itemId).retrieve()
                    .bodyToMono(InventoryDto.class).block();
        } catch (WebClientResponseException.NotFound e) {
            throw new EntityNotFoundException("Item id " + itemId + " not found");
        } catch (WebClientResponseException e) {
            throw new RuntimeException(e.getMessage());
        }
        Order savedOrder = orderRepository.save(convertToEntity(orderDto));
        return convertToDto(savedOrder);
    }

    @Override
    public OrderDto updateOrder(Integer orderId, OrderDto orderDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
    }

    @Override
    public String deleteOrder(Integer orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new EntityNotFoundException("Order id " + orderId + " not found");
        }
        orderRepository.deleteById(orderId);
        return "Successfully Deleted";
    }

    private OrderDto convertToDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setItemId(order.getItemId());
        dto.setAmount(order.getAmount());
        dto.setOrderDate(order.getOrderDate());
        return dto;
    }

    private Order convertToEntity(OrderDto orderDto) {
        Order entity = new Order();
        entity.setId(orderDto.getId());
        entity.setItemId(orderDto.getItemId());
        entity.setAmount(orderDto.getAmount());
        entity.setOrderDate(orderDto.getOrderDate());
        return entity;
    }

}
