package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.OrderItemDTO;
import com.sportswear.sportswear.service.interfaces.OrderItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order-item")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @PostMapping(value = "/create")
    public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody @Valid OrderItemDTO orderItemDTO) {
        return ResponseEntity.ok().body(orderItemService.createOrderItem(orderItemDTO));
    }

    @GetMapping(value = "/get/by/order/id/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemByOrderId(@PathVariable @Valid UUID id) throws Exception {
        return ResponseEntity.ok().body(orderItemService.getOrderItemByOrderId(id));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<OrderItemDTO> updateOrderItemById(@RequestBody @Valid OrderItemDTO orderItemDTO) {
        return ResponseEntity.ok().body(orderItemService.updateOrderItemById(orderItemDTO));
    }

    @DeleteMapping(value = "/delete/by/id/{id}")
    public ResponseEntity<String> deleteOrderItemById(@PathVariable @ Valid UUID id) {
        return ResponseEntity.ok().body(orderItemService.deleteOrderItemById(id));
    }
}
