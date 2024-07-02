package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.ClientDTO;
import com.sportswear.sportswear.service.interfaces.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping(value = "/create")
    public void createClient(@RequestBody @Valid ClientDTO createDTO) {
        clientService.createClient(createDTO);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<ClientDTO> getClient() {
        return ResponseEntity.ok().body(clientService.getClient());
    }

    @PutMapping(value = "/update")
    public void updateClient(@RequestBody @Valid ClientDTO updateDTO) {
        clientService.updateClient(updateDTO);
    }
}
