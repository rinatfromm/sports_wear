package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.dto.ItemDTO;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    ItemDTO createItem(ItemDTO itemDTO);
    ItemDTO getItemById(UUID id);
    List<ItemDTO> getAllItems();
    ImageDTO addImageToProduct(UUID productId, ImageDTO imageDTO);
    void updateItemById(ItemDTO itemDTO);
}
