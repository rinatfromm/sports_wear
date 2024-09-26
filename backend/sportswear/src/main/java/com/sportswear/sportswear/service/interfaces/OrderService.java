package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.OrderDTO;
import com.sportswear.sportswear.dto.OrderGetDTO;
import com.sportswear.sportswear.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderGetDTO createOrder(UUID clientId);
    OrderGetDTO getOrderById(UUID id);
    List<OrderGetDTO> getAllOrders();
    List<Order> getAllNormalOrders();
    OrderDTO updateOrder(OrderDTO orderDTO);
    String deleteOrderById(UUID id);
}
