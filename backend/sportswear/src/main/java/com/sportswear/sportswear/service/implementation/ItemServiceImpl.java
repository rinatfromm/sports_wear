package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ItemDTOConverter;
import com.sportswear.sportswear.dto.ItemDTO;
import com.sportswear.sportswear.entity.Item;
import com.sportswear.sportswear.repository.ItemRepository;
import com.sportswear.sportswear.service.interfaces.ItemService;
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
    private final ItemDTOConverter itemDTOConverter;

    @Override
    public void createItem(ItemDTO itemDTO) {
        itemRepository.save(itemDTOConverter.convertDTOToItem(itemDTO));
        log.info("Create item.");
    }

    @Override
    public ItemDTO getItemById(UUID id) {
        log.info("Get item by id.");
        return itemDTOConverter.convertItemToDTO(itemRepository.findAllById(id));
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        log.info("Get all items.");
        return itemDTOConverter.convertItemsToDTOs(items);
    }

    @Override
    public void updateItemById(ItemDTO itemDTO) {
        Item item = itemDTOConverter.convertDTOToItem(itemDTO);
        itemRepository.save(item);
        log.info("Update item by id.");
    }
}
