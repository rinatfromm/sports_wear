package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.dto.OrderDTO;
import com.sportswear.sportswear.entity.Order;
import com.sportswear.sportswear.service.interfaces.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    @Override
    public OrderDTO createOrderItem(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO getOrderItemByOrderId(UUID id) {
        return null;
    }

    @Override
    public List<Order> getOrderItemsByClientId(UUID id) {
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
