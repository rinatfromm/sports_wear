package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.OrderDTO;

import java.util.UUID;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(UUID id);
    OrderDTO updateOrder(OrderDTO orderDTO);
    String deleteOrderById(UUID id);
}
