package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.OrderDTO;
import com.sportswear.sportswear.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderItemService {
    OrderDTO createOrderItem(OrderDTO orderDTO);
    OrderDTO getOrderItemByOrderId(UUID id);
    List<Order> getOrderItemsByClientId(UUID id);
    OrderDTO updateOrderById(OrderDTO orderDTO);
    String deleteOrderById(UUID id);
}
