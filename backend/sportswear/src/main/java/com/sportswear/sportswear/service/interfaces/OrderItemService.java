package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.OrderItemDTO;
import java.util.UUID;

public interface OrderItemService {
    OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO);
    OrderItemDTO getOrderItemByOrderId(UUID id) throws Exception;
    OrderItemDTO updateOrderItemById(OrderItemDTO orderItemDTO);
    String deleteOrderItemById(UUID id);
}
