package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.entity.Image;
import com.sportswear.sportswear.service.interfaces.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(@RequestParam("file") MultipartFile image) throws IOException {
        imageService.uploadImage(image);
    }

    @GetMapping(value = "/get/by/item/id/{id}")
    public ResponseEntity<List<Image>> getImageByItemId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(imageService.getAllImagesByItemId(id));
    }

    @GetMapping(value = "/get/test")
    public ResponseEntity<Resource> getImageTest() {
        String imageName = "nike.jpg";
        Resource file = new FileSystemResource("src/main/resources/images/" + imageName);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(file);
    }

    @PostMapping(value = "/get/all")
    public ResponseEntity<List<Image>> getAllImages() {
        return ResponseEntity.ok().body(imageService.getAllImages());
    }

    @PutMapping(value = "/update")
    public void updateBasketById(@RequestBody @Valid ImageDTO imageDTO) {
        imageService.updateImageById(imageDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteImageById(@PathVariable UUID id) {
        imageService.deleteImageById(id);
    }
}
