package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.ClientDTO;
import com.sportswear.sportswear.service.interfaces.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping(value = "/create")
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientDTO createDTO) {
        return ResponseEntity.ok().body(clientService.createClient(createDTO));
    }

    @GetMapping(value = "/get/by/id/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ClientDTO> updateClientById(@RequestBody @Valid ClientDTO clientDTO) {
        return ResponseEntity.ok().body(clientService.updateClient(clientDTO));
    }

    @DeleteMapping(value = "/delete/by/id{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(clientService.deleteClientById(id));
    }
}
