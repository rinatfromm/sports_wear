package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.OrderItemDTO;
import com.sportswear.sportswear.entity.OrderItem;

import java.util.UUID;

public interface OrderItemService {
    OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO);
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItemDTO getOrderItemByOrderId(UUID id) throws Exception;
    OrderItemDTO updateOrderItemById(OrderItemDTO orderItemDTO);
    String deleteOrderItemById(UUID id);
}
