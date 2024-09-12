package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.OrderDTOConverter;
import com.sportswear.sportswear.dto.OrderDTO;
import com.sportswear.sportswear.dto.OrderGetDTO;
import com.sportswear.sportswear.entity.Order;
import com.sportswear.sportswear.repository.OrderRepository;
import com.sportswear.sportswear.service.interfaces.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDTOConverter orderDTOConverter;

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderRepository.save(orderDTOConverter.convertDTOToOrder(orderDTO));
        log.info("Create client.");
        return orderDTOConverter.convertOrderToDTO(order);
    }

    @Override
    @Transactional
    public OrderDTO getOrderById(UUID id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Order does not exist!"));
        log.info("Get order. id " + id);
        return orderDTOConverter.convertOrderToDTO(order);
    }

    @Override
    @Transactional
    public List<OrderGetDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderDTOConverter.convertOrdersToGetDTOs(orders);
    }

    @Override
    @Transactional
    public List<Order> getAllNormalOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    @Transactional
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        if (!orderRepository.existsById(orderDTO.getId())) {
            throw new NoSuchElementException("Could not update non existing order!");
        }
        Order order = orderRepository.save(orderDTOConverter.convertDTOToOrder(orderDTO));
        log.info("Update order.");
        return orderDTOConverter.convertOrderToDTO(order);
    }

    @Override
    @Transactional
    public String deleteOrderById(UUID id) {
        if (!orderRepository.existsById(id)) {
            throw new NoSuchElementException("Could not delete non existing order item! id " + id);
        }
        orderRepository.deleteById(id);
        return "Order deleted! id " + id;
    }
}
