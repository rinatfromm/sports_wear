package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.ClientDTO;
import com.sportswear.sportswear.dto.ClientGetDTO;
import com.sportswear.sportswear.dto.DeliveryAddressDTO;
import com.sportswear.sportswear.service.interfaces.ClientService;
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

    @GetMapping(value = "/get/by/id/{id}")
    public ResponseEntity<ClientGetDTO> getClientById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }


    @GetMapping(value = "/get/all")
    public ResponseEntity<List<ClientGetDTO>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ClientGetDTO> updateClientById(@RequestBody @Valid ClientGetDTO clientDTO) {
        return ResponseEntity.ok().body(clientService.updateClient(clientDTO));
    }

    @DeleteMapping(value = "/delete/by/id{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(clientService.deleteClientById(id));
    }
}
