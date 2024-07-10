package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.service.interfaces.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping(value = "/create")
    public void createImage(@RequestBody @Valid ImageDTO imageDTO) {
        imageService.createImage(imageDTO);
    }

    @GetMapping(value = "/get/by/id/{uuid}")
    public ResponseEntity<ImageDTO> getImageById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(imageService.getImageById(id));
    }

    @PostMapping(value = "/get/all")
    public ResponseEntity<List<ImageDTO>> getAllImages() {
        return ResponseEntity.ok().body(imageService.getAllImages());
    }

    @PutMapping(value = "/update")
    public void updateBasketById(@RequestBody @Valid ImageDTO imageDTO) {
        imageService.updateImageById(imageDTO);
    }
}
