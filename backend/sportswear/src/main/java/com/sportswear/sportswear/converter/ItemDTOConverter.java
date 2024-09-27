package com.sportswear.sportswear.converter;

import com.sportswear.sportswear.dto.ItemDTO;
import com.sportswear.sportswear.dto.ItemGetDTO;
import com.sportswear.sportswear.dto.ItemGroupedDTO;
import com.sportswear.sportswear.dto.ItemVariantsDTO;
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

    public ItemGetDTO convertItemToGetDTO(Item item) {
        return modelMapper.map(item, ItemGetDTO.class);
    }

    public ItemGroupedDTO convertItemToGroupedDTO(Item item) {
        return modelMapper.map(item, ItemGroupedDTO.class);
    }

    public ItemVariantsDTO convertItemToVariantsDTO(Item item) {
        return modelMapper.map(item, ItemVariantsDTO.class);
    }

    public List<ItemDTO> convertItemsToDTOs(List<Item> items) {
        List<ItemDTO> itemDTOs = new LinkedList<>();
        for (Item item : items) {
            itemDTOs.add(modelMapper.map(item, ItemDTO.class));
        }
        return itemDTOs;
    }

    public List<ItemGetDTO> convertItemsToGetDTOs(List<Item> items) {
        List<ItemGetDTO> itemDTOs = new LinkedList<>();
        for (Item item : items) {
            itemDTOs.add(modelMapper.map(item, ItemGetDTO.class));
        }
        return itemDTOs;
    }

    public List<ItemGroupedDTO> convertItemsToGroupedDTOs(List<Item> items) {
        List<ItemGroupedDTO> itemDTOs = new LinkedList<>();
        for (Item item : items) {
            itemDTOs.add(modelMapper.map(item, ItemGroupedDTO.class));
        }
        return itemDTOs;
    }

    public List<ItemVariantsDTO> convertItemsToVariantsDTOs(List<Item> items) {
        List<ItemVariantsDTO> itemDTOs = new LinkedList<>();
        for (Item item : items) {
            itemDTOs.add(modelMapper.map(item, ItemVariantsDTO.class));
        }
        return itemDTOs;
    }
}
