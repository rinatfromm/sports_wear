package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.OrderDTO;
import com.sportswear.sportswear.service.interfaces.OrderService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping(value = "/create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody @Valid OrderDTO orderDTO) {
        return ResponseEntity.ok().body(orderService.createOrder(orderDTO));
    }

    @GetMapping(value = "/get/by/id/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<OrderDTO> updateOrderById(@RequestBody @Valid OrderDTO orderDTO) {
        return ResponseEntity.ok().body(orderService.updateOrder(orderDTO));
    }

    @DeleteMapping(value = "/delete/by/id/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(orderService.deleteOrderById(id));
    }
}
