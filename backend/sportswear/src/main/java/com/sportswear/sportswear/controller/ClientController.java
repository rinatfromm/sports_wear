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
    public void createClient(@RequestBody @Valid ClientDTO createDTO) {
        clientService.createClient(createDTO);
    }

    @GetMapping(value = "/get/by/id/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @PutMapping(value = "/update")
    public void updateClientById(@RequestBody @Valid ClientDTO clientDTO) {
        clientService.updateClientById(clientDTO);
    }
}
