package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.service.interfaces.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
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

    @GetMapping(value = "/get/test")
    public ResponseEntity<Resource> getImageTest() throws IOException { // @PathVariable String imageName
        String imageName = "nike.jpg";
        Resource file = new FileSystemResource("/Users/rinatfromm/Desktop/sports_wear/sports_wear/backend/sportswear/src/main/resources/images/" + imageName);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(file);
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
