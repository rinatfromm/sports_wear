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
        log.info("Get item by id.");
        return itemDTOConverter.convertItemToDTO(itemRepository.findById(id).orElse(null));
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
        //image.setImageName();
        image = imageRepository.save(image);
        return imageDTOConverter.convertImageToDTO(image);
    }

    @Override
    @Transactional
    public void updateItemById(ItemDTO itemDTO) {
        Item item = itemDTOConverter.convertDTOToItem(itemDTO);
        itemRepository.save(item);
        log.info("Update item by id.");
    }
}
