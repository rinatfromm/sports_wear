package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.ItemDTO;
import com.sportswear.sportswear.service.interfaces.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item")
public class ItemController {
    private final ItemService itemService;

    @PostMapping(value = "/create")
    public void createBasket(@RequestBody @Valid ItemDTO itemDTO) {
        itemService.createItem(itemDTO);
    }

    @GetMapping(value = "/get/by/id/{uuid}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(itemService.getItemById(id));
    }

    @PostMapping(value = "/get/all")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        return ResponseEntity.ok().body(itemService.getAllItems());
    }

    @PutMapping(value = "/update")
    public void updateItemById(@RequestBody @Valid ItemDTO itemDTO) {
        itemService.updateItemById(itemDTO);
    }
}
