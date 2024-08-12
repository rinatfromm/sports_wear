package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.DeliveryAddressDTO;
import com.sportswear.sportswear.service.interfaces.DeliveryAddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/delivery-address")
public class DeliveryAddressController {
    private final DeliveryAddressService deliveryAddressService;

    @PostMapping(value = "/create")
    public ResponseEntity<DeliveryAddressDTO> createDeliveryAddress(@RequestBody @Valid DeliveryAddressDTO deliveryAddressDTO) {
        return ResponseEntity.ok().body(deliveryAddressService.createDeliveryAddress(deliveryAddressDTO));
    }

    @GetMapping(value = "/get/by/id/{id}")
    public ResponseEntity<DeliveryAddressDTO> getDeliveryAddressById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(deliveryAddressService.getDeliveryAddressById(id));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<DeliveryAddressDTO> updateDeliveryAddress(@RequestBody @Valid DeliveryAddressDTO deliveryAddressDTO) {
        return ResponseEntity.ok().body(deliveryAddressService.updateDeliveryAddress(deliveryAddressDTO));
    }

    @DeleteMapping(value = "/delete/by/id/{id}")
    public ResponseEntity<String> deleteDeliveryAddressById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(deliveryAddressService.deleteDeliveryAddressById(id));
    }
}
