package com.sportswear.sportswear.converter;

import com.sportswear.sportswear.dto.OrderItemDTO;
import com.sportswear.sportswear.entity.OrderItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderItemDTOConverter {
    private final ModelMapper modelMapper;

    public OrderItem convertDTOToOrderItem(OrderItemDTO orderItemDTO) {
        return modelMapper.map(orderItemDTO, OrderItem.class);
    }

    public OrderItemDTO convertOrderItemToDTO(OrderItem orderItem) {
        return modelMapper.map(orderItem, OrderItemDTO.class);
    }

    public List<OrderItemDTO> convertOrderItemsToDTOs(List<OrderItem> orderItems) {
        List<OrderItemDTO> orderItemDTOs = new LinkedList<>();
        for (OrderItem orderItem : orderItems) {
            orderItemDTOs.add(modelMapper.map(orderItem, OrderItemDTO.class));
        }
        return orderItemDTOs;
    }
}
