package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.ItemDTO;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    void createItem(ItemDTO itemDTO);
    ItemDTO getItemById(UUID id);
    List<ItemDTO> getAllItems();
    void updateItemById(ItemDTO itemDTO);
}
