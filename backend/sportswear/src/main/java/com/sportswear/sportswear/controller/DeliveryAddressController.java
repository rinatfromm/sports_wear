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
    public void createDeliveryAddress(@RequestBody @Valid DeliveryAddressDTO deliveryAddressDTO) {
        deliveryAddressService.createDeliveryAddress(deliveryAddressDTO);
    }

    @GetMapping(value = "/get/by/id/{uuid}")
    public ResponseEntity<DeliveryAddressDTO> getDeliveryAddressById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(deliveryAddressService.getDeliveryAddressById(id));
    }

    @PutMapping(value = "/update")
    public void updateDeliveryAddressById(@RequestBody @Valid DeliveryAddressDTO deliveryAddressDTO) {
        deliveryAddressService.updateDeliveryAddressById(deliveryAddressDTO);
    }
}
