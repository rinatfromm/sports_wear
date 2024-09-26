package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.OrderDTOConverter;
import com.sportswear.sportswear.dto.OrderDTO;
import com.sportswear.sportswear.dto.OrderGetDTO;
import com.sportswear.sportswear.entity.Client;
import com.sportswear.sportswear.entity.Order;
import com.sportswear.sportswear.repository.ClientRepository;
import com.sportswear.sportswear.repository.OrderRepository;
import com.sportswear.sportswear.service.interfaces.ClientService;
import com.sportswear.sportswear.service.interfaces.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public OrderGetDTO createOrder(UUID clientId) {
        log.warn("Order DTO in service : " + clientId);
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NoSuchElementException("Client does not exist!"));
        Order order = new Order();
        order.setClient(client);
        log.warn(" order before client assignment : " + order);
        order = orderRepository.save(order);
//        client.getOrders().add(order);
//        client = clientRepository.save(client);
        log.warn(" order when client connected : " + order);
//        log.warn("client: " + client.getOrders());
        log.info("Create order. " + order);
        return orderDTOConverter.convertOrderToGetDTO(order);
    }

    @Override
    @Transactional
    public OrderGetDTO getOrderById(UUID id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Order does not exist!"));
        log.info("Get order. id " + id);
        return orderDTOConverter.convertOrderToGetDTO(order);
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
        log.info("order DTO : " + orderDTO);
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
