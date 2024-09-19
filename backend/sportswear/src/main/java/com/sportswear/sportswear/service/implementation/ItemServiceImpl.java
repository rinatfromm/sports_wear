package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ImageDTOConverter;
import com.sportswear.sportswear.converter.ItemDTOConverter;
import com.sportswear.sportswear.dto.*;
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
import java.util.LinkedList;
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
    public List<ItemGetDTO> getAllItems() {
        // Get all items
        List<Item> items = itemRepository.findAll();

        // Convert all item entities to get item DTOs
        List<ItemGetDTO> itemsDTO = itemDTOConverter.convertItemsToGetDTOs(items);

        // Convert all items images to imageURLs
        imageToURL(items, itemsDTO);

        log.info("Get all items.");
        return itemsDTO;
    }

    @Override
    @Transactional
    public ItemGroupedDTO getGroupedItem() {
        // Test name
//        String name = "t-sprin";
        String name = "Jeans Lossy";

        // Get list of all items with the same name
        List<Item> items = itemRepository.findAllByName(name);

        // Return null if list is less than 2 elements!
        if (items.size() < 1) {
            return null;
        }

        // Convert all items to grouped items except imageURLs and colorSizeDTOs
        List<ItemGroupedDTO> groupedDTOs = itemDTOConverter.convertItemsToGroupedDTOs(items);

        // Convert images to imageURLs and add it to DTOs
        imageToGroupedURL(items, groupedDTOs);

        // Result item with all sizes
        ItemGroupedDTO itemGrouped = groupedDTOs.get(0);

        itemGrouped.setColorDTOs(getAllColorDTOs(items, itemGrouped.getName()));

        return itemGrouped;
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

    private String buildImageURL(UUID id) {
//        return imagePath + id + imageType;
        return imageService.downloadImageTest(id);
    }

    private void imageToURL(List<Item> items, List<ItemGetDTO> itemsDTO) {
        // Convert every image in item to image URLs
        for (int index = 0; index < items.size(); index++) {
            List<Image> images = items.get(index).getImages();
            List<String> imageURLs = new LinkedList<>();

            // Convert image id to full image path
            for (Image image : images) {
                imageURLs.add(buildImageURL(image.getId()));
            }

            // Set image URLs to item
            itemsDTO.get(index).setImageURLs(imageURLs);
        }
    }

    private void imageToGroupedURL(List<Item> items, List<ItemGroupedDTO> itemsDTO) {
        // Convert every image in item to image URLs
        for (int index = 0; index < items.size(); index++) {
            List<Image> images = items.get(index).getImages();
            List<String> imageURLs = new LinkedList<>();

            // Convert image id to full image path
            for (Image image : images) {
                imageURLs.add(buildImageURL(image.getId()));
            }

            // Set image URLs to item
            itemsDTO.get(index).setImageURLs(imageURLs);
        }
    }

    private List<ColorDTO> getAllColorDTOs(List<Item> items, String name) {
        List<ColorDTO> colorDTOs = new LinkedList<>();
        List<UUID> usedItems = new LinkedList<>();

        for (int index = 0; index < items.size(); index++) {
            if (name.equals(items.get(index).getName()) &&
                    !usedItems.contains(items.get(index).getId())) {
                ColorDTO colorDTO = new ColorDTO();
                colorDTO.setColor(items.get(index).getColor());
                colorDTO.setSizeDTOs(getAllSizeDTOs(items, usedItems, items.get(index).getColor()));
                colorDTOs.add(colorDTO);
            }
        }
        return colorDTOs;
    }

    private List<SizeDTO> getAllSizeDTOs(List<Item> items, List<UUID> usedItems, String color) {
        List<SizeDTO> sizeDTOs = new LinkedList<>();

        for (int index = 0; index < items.size(); index++) {
            if (color.equals(items.get(index).getColor()) &&
                    !usedItems.contains(items.get(index).getId())) {
                SizeDTO size = new SizeDTO();
                size.setSize(items.get(index).getSize());
                size.setItemId(items.get(index).getId());
                usedItems.add(items.get(index).getId());
                sizeDTOs.add(size);
            }
        }
        return sizeDTOs;
    }

}
