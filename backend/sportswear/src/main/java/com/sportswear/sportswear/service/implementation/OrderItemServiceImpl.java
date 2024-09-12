package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.OrderItemDTOConverter;
import com.sportswear.sportswear.dto.OrderItemDTO;
import com.sportswear.sportswear.entity.OrderItem;
import com.sportswear.sportswear.repository.OrderItemRepository;
import com.sportswear.sportswear.service.interfaces.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemDTOConverter orderItemDTOConverter;
    private final OrderItemRepository orderItemRepository;


    @Override
    public OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = orderItemRepository.save(orderItemDTOConverter.convertDTOToOrderItem(orderItemDTO));
        return orderItemDTOConverter.convertOrderItemToDTO(orderItem);
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItemDTO getOrderItemByOrderId(UUID id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Order item does not exist!"));
        return orderItemDTOConverter.convertOrderItemToDTO(orderItem);
    }

    @Override
    public OrderItemDTO updateOrderItemById(OrderItemDTO orderItemDTO) {
        if (!orderItemRepository.existsById(orderItemDTO.getId())) {
            throw new NoSuchElementException("Could not update non existing order item!");
        }
        OrderItem orderItem = orderItemRepository.save(orderItemDTOConverter.convertDTOToOrderItem(orderItemDTO));
        return orderItemDTOConverter.convertOrderItemToDTO(orderItem);
    }

    @Override
    public String deleteOrderItemById(UUID id) {
        if (!orderItemRepository.existsById(id)) {
            throw new NoSuchElementException("Could not delete non existing order item!");
        }
        orderItemRepository.deleteById(id);
        return "Order item deleted!";
    }
}
