package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.*;
import com.sportswear.sportswear.entity.Order;
import com.sportswear.sportswear.service.interfaces.ClientService;
import com.sportswear.sportswear.service.interfaces.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping(value = "/create")
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientDTO createDTO) {
        return ResponseEntity.ok().body(clientService.createClient(createDTO));
    }

    @PostMapping(value = "/add/delivery-address")
    public ResponseEntity<String> addDeliveryAddress(@RequestBody @Valid DeliveryAddressDTO deliveryAddressDTO) {
        clientService.addDeliveryAddress(deliveryAddressDTO);
        return ResponseEntity.ok().body("Delivery address added! To client id " + deliveryAddressDTO.getClient());
    }

    @DeleteMapping(value = "/delete/delivery-address/by/id/{id}")
    public ResponseEntity<String> deleteDeliveryAddress(@PathVariable @Valid UUID id) {
        clientService.deleteDeliveryAddress(id);
        return ResponseEntity.ok().body("Delivery address deleted! From client id " + id);
    }

    @PostMapping(value = "/add/order")
    public ResponseEntity<String> addOrder(@RequestBody @Valid OrderDTO orderDTO) {
        clientService.addOrder(orderDTO);
        return ResponseEntity.ok().body("Order added! To client id " + orderDTO.getClient());
    }

    @DeleteMapping(value = "/delete/order/by/id/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable @Valid UUID id) {
        clientService.deleteOrder(id);
        return ResponseEntity.ok().body("Order deleted! From client id " + id);
    }

    @PostMapping(value = "/add/item/to/order")
    public ResponseEntity<String> addOrderItem(@RequestBody @Valid OrderItemDTO orderItemDTO) {
        clientService.addItemToOrder(orderItemDTO);
        return ResponseEntity.ok().body("Added item. id " + orderItemDTO.getItemId() + " to order with id " + orderItemDTO.getOrderId());
    }

    @DeleteMapping(value = "/delete/item/from/order/by/id/{id}")
    public ResponseEntity<String> deleteItemFromOrder(@PathVariable @Valid UUID id) {
        clientService.deleteItemFromOrder(id);
        return ResponseEntity.ok().body("Delete item with id " + id);
    }

    @GetMapping(value = "/get/by/id/{id}")
    public ResponseEntity<ClientGetDTO> getClientById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<ClientGetDTO>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @GetMapping(value = "/get/all/orders")
    public ResponseEntity<List<OrderGetDTO>> getAllOrders() {
        return ResponseEntity.ok().body(clientService.getAllOrders());
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ClientGetDTO> updateClientById(@RequestBody @Valid ClientGetDTO clientDTO) {
        return ResponseEntity.ok().body(clientService.updateClient(clientDTO));
    }

    @DeleteMapping(value = "/delete/by/id{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(clientService.deleteClientById(id));
    }

    // Debug
    private final OrderService orderService;

    @GetMapping(value = "/test/get/list/of/order-items")
    public ResponseEntity<List<OrderGetDTO>> testGetOrders() {
        List<OrderGetDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }
}
