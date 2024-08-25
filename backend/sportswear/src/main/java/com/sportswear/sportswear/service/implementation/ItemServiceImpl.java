package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ImageDTOConverter;
import com.sportswear.sportswear.converter.ItemDTOConverter;
import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.dto.ItemDTO;
import com.sportswear.sportswear.entity.Image;
import com.sportswear.sportswear.entity.Item;
import com.sportswear.sportswear.repository.ImageRepository;
import com.sportswear.sportswear.repository.ItemRepository;
import com.sportswear.sportswear.service.interfaces.ItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ImageRepository imageRepository;
    private final ItemDTOConverter itemDTOConverter;
    private final ImageDTOConverter imageDTOConverter;

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
    public ImageDTO addImageToProduct(UUID itemId, ImageDTO imageDTO) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found!"));
        Image image = imageDTOConverter.convertDTOToImage(imageDTO);
        image = imageRepository.save(image);
        return imageDTOConverter.convertImageToDTO(image);
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
    public String deleteItemById(UUID id) {
        if (!itemRepository.existsById(id)) {
            throw new NoSuchElementException("Could not delete non existing item!");
        }
        itemRepository.deleteById(id);
        return "Item deleted! id " + id;
    }
}
