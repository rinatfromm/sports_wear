package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.dto.OrderDTO;
import com.sportswear.sportswear.entity.Order;
import com.sportswear.sportswear.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO getOrderById(UUID id) {
        return null;
    }

    @Override
    public List<Order> getOrdersByClientId(UUID id) {
        return List.of();
    }

    @Override
    public OrderDTO updateOrderById(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public String deleteOrderById(UUID id) {
        return "";
    }
}
