package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.OrderDTO;
import com.sportswear.sportswear.dto.OrderGetDTO;
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
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping(value = "/create/by/client/id/{id}")
    public ResponseEntity<OrderGetDTO> createOrder(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(orderService.createOrder(id));
    }

    @GetMapping(value = "/get/by/id/{id}")
    public ResponseEntity<OrderGetDTO> getOrderById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<OrderGetDTO>> getAllDtoOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @DeleteMapping(value = "/delete/by/id/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(orderService.deleteOrderById(id));
    }
}
