package com.sportswear.sportswear.converter;

import com.sportswear.sportswear.dto.OrderDTO;
import com.sportswear.sportswear.entity.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDTOConverter {
    private final ModelMapper modelMapper;

    public Order convertDTOToOrder(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }

    public OrderDTO convertOrderToDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public List<OrderDTO> convertOrdersToDTOs(List<Order> orders) {
        List<OrderDTO> orderDTOs = new LinkedList<>();
        for (Order order : orders) {
            orderDTOs.add(modelMapper.map(order, OrderDTO.class));
        }
        return orderDTOs;
    }
}