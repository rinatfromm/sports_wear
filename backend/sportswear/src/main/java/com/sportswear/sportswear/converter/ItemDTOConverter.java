package com.sportswear.sportswear.converter;

import com.sportswear.sportswear.dto.ItemDTO;
import com.sportswear.sportswear.entity.Item;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemDTOConverter {
    private final ModelMapper modelMapper;

    public Item convertDTOToItem(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }

    public ItemDTO convertItemToDTO(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }

    public List<ItemDTO> convertItemsToDTOs(List<Item> items) {
        List<ItemDTO> itemDTOs = new LinkedList<>();
        for (Item item : items) {
            itemDTOs.add(modelMapper.map(item, ItemDTO.class));
        }
        return itemDTOs;
    }
}
