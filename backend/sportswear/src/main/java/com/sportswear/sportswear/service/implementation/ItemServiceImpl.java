package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ImageDTOConverter;
import com.sportswear.sportswear.converter.ItemDTOConverter;
import com.sportswear.sportswear.dto.ItemDTO;
import com.sportswear.sportswear.entity.Image;
import com.sportswear.sportswear.entity.Item;
import com.sportswear.sportswear.repository.ImageRepository;
import com.sportswear.sportswear.repository.ItemRepository;
import com.sportswear.sportswear.service.interfaces.ImageService;
import com.sportswear.sportswear.service.interfaces.ItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ImageRepository imageRepository;
    private final ImageService imageService;
    private final ItemDTOConverter itemDTOConverter;
    private final ImageDTOConverter imageDTOConverter;

    @Value(value = "${image.path}")
    private String imagePath;

    @Value(value = "${image.type}")
    private String imageType;

    @Override
    @Transactional
    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = itemRepository.save(itemDTOConverter.convertDTOToItem(itemDTO));
        log.info("Create item.");
        return itemDTOConverter.convertItemToDTO(item);
    }

    @Override
    @Transactional
    public ItemDTO getItemById(UUID id) {
        Item item = itemRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Item does not exist!"));
        log.info("Get item by id." + id);
        return itemDTOConverter.convertItemToDTO(item);
    }

    @Override
    @Transactional
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        log.info("Get all items.");
        return itemDTOConverter.convertItemsToDTOs(items);
    }

    @Override
    @Transactional
    public void addImage(UUID itemId, MultipartFile imageFile) throws IOException {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new NoSuchElementException("Item not found!"));
        log.info(item.toString());
//        ImageDTO imageDTO = imageService.uploadImage(imageDTO.getItem(), imageFile);
        Image image = imageDTOConverter.convertDTOToImage(imageService
                .uploadImage(itemId, imageFile));
        image.setItemId(item.getId());
//        UUID imageId = UUID.randomUUID();
//        String imageName = imageId + imageType;
//        String imageUrl = imagePath + imageName;
//        Image dbImage = new Image();
//        dbImage.setId(imageId);
//        dbImage.setItemId(itemId);
//        Image image = imageRepository.save(dbImage);
//        Files.write(Paths.get(imageUrl), imageFile.getBytes());
//        log.info("Upload image. id " + itemId);

        item.getImages().add(image);
        itemRepository.save(item);
    }

    @Override
    @Transactional
    public void deleteImage(UUID id) {
        if (!imageRepository.existsById(id)) {
            log.warn("No such image!");
            throw new NoSuchElementException("Image does not exist!");
        }
        imageRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ItemDTO updateItemById(ItemDTO itemDTO) {
        if (!itemRepository.existsById(itemDTO.getId())) {
            throw new NoSuchElementException("Could not update non existing item!");
        }
        Item item = itemRepository.save(itemDTOConverter.convertDTOToItem(itemDTO));
        log.info("Update item by id.");
        return itemDTOConverter.convertItemToDTO(item);
    }

    @Override
    @Transactional
    public String deleteItemById(UUID id) {
        if (!itemRepository.existsById(id)) {
            throw new NoSuchElementException("Could not delete non existing item!");
        }
        itemRepository.deleteById(id);
        return "Item deleted! id " + id;
    }
}
