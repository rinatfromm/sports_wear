package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.service.interfaces.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping(value = "/upload/by/item/id/{itemId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(@PathVariable @Valid UUID itemId,
                                              @RequestParam("file") MultipartFile image) throws IOException {
        imageService.uploadImage(itemId, image);
        return ResponseEntity.ok().body("Image uploaded! id : " + itemId);
    }

    @GetMapping(value = "/download/by/id/{id}")
    public ResponseEntity<Resource> downloadImage(@PathVariable @Valid UUID id) throws IOException {
        Resource file = imageService.downloadImage(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFilename());
        headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(file.getURI())));

        return new ResponseEntity<>(file, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/get/by/item/id/{id}")
    public ResponseEntity<List<ImageDTO>> getImageByItemId(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(imageService.getAllImagesByItemId(id));
    }

    @GetMapping(value = "/get/test/id/{id}")
    public ResponseEntity<String> getImageTest(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(imageService.downloadImageTest(id));
    }

    @PostMapping(value = "/get/all")
    public ResponseEntity<List<ImageDTO>> getAllImages() {
        return ResponseEntity.ok().body(imageService.getAllImages());
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ImageDTO> updateBasketById(@RequestBody @Valid ImageDTO imageDTO) {
        return ResponseEntity.ok().body(imageService.updateImage(imageDTO));
    }

    @DeleteMapping(value = "/delete/by/{id}")
    public ResponseEntity<String> deleteImageById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(imageService.deleteImageById(id));
    }
}
