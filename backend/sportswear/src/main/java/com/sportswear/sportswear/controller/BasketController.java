package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.BasketDTO;
import com.sportswear.sportswear.service.interfaces.BasketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/basket")
public class BasketController {
    private final BasketService basketService;

    @PostMapping(value = "/create")
    public void createBasket(@RequestBody @Valid BasketDTO basketDTO) {
        basketService.createBasket(basketDTO);
    }

    @GetMapping(value = "/get/by/id/{uuid}")
    public ResponseEntity<BasketDTO> getBasketById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(basketService.getBasketById(id));
    }

    @PutMapping(value = "/update")
    public void updateBasketById(@RequestBody @Valid BasketDTO basketDTO) {
        basketService.updateBasketById(basketDTO);
    }
}
