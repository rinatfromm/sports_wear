package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.ItemDTO;
import com.sportswear.sportswear.dto.ItemGetDTO;
import com.sportswear.sportswear.dto.ItemGroupedDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ItemService {
    ItemDTO createItem(ItemDTO itemDTO);
    ItemDTO getItemById(UUID id);
    List<ItemGetDTO> getAllItems();
    ItemGroupedDTO getGroupedItem();
    void addImage(UUID id, MultipartFile imageFile) throws IOException;
    void deleteImage(UUID id);
    ItemDTO updateItemById(ItemDTO itemDTO);
    String deleteItemById(UUID id);
}
