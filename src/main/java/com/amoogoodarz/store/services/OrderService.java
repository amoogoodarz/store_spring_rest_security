package com.amoogoodarz.store.services;

import com.amoogoodarz.store.dtos.order.OrderDto;
import com.amoogoodarz.store.exceptions.OrderNotFoundException;
import com.amoogoodarz.store.mappers.OrderMapper;
import com.amoogoodarz.store.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class OrderService {
    private final AuthService authService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> getAllOrders(){
        var user =  authService.getCurrentUser();
        var orders = orderRepository.getOrdersByCustomer(user);
        return orders.stream().map(orderMapper::toDto).toList();
    }

    public OrderDto getOrder(Long orderId){
        var order = orderRepository.getOrderWithItems(orderId).orElseThrow(OrderNotFoundException::new);
        var curUser = authService.getCurrentUser();
        if(!order.isPlacedBy(curUser))
            throw new AccessDeniedException("Access denied");
        return orderMapper.toDto(order);
    }
}
