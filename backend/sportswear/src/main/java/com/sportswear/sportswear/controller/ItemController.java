package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.dto.ItemDTO;
import com.sportswear.sportswear.dto.ItemGetDTO;
import com.sportswear.sportswear.dto.ItemGroupedDTO;
import com.sportswear.sportswear.service.interfaces.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item")
public class ItemController {
    private final ItemService itemService;

    @PostMapping(value = "/create")
    public ResponseEntity<ItemDTO> createItem(@RequestBody @Valid ItemDTO itemDTO) {
        return ResponseEntity.ok().body(itemService.createItem(itemDTO));
    }

    @PostMapping(value = "/add/image/by/item/id/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addImage(@PathVariable @Valid UUID id,
                                           @RequestParam("file") MultipartFile image) throws IOException {
        itemService.addImage(id, image);
        return ResponseEntity.ok().body("Image added to item id : " + id);
    }

    @DeleteMapping(value = "/delete/image/by/id/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable @Valid UUID id) {
        itemService.deleteImage(id);
        return ResponseEntity.ok().body("Image deleted from item id : " + id);
    }

    @GetMapping(value = "/get/by/id/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(itemService.getItemById(id));
    }

    @PostMapping(value = "/get/all")
    public ResponseEntity<List<ItemGetDTO>> getAllItems() {
        return ResponseEntity.ok().body(itemService.getAllItems());
    }

    @PostMapping(value = "/get/grouped/item")
    public ResponseEntity<ItemGroupedDTO> getAllGroupedItems() {
        return ResponseEntity.ok().body(itemService.getGroupedItem());
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ItemDTO> updateItemById(@RequestBody @Valid ItemDTO itemDTO) {
        return ResponseEntity.ok().body(itemService.updateItemById(itemDTO));
    }

    @DeleteMapping(value = "/delete/by/id/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable @Valid UUID id) {
        return ResponseEntity.ok().body(itemService.deleteItemById(id));
    }
}
