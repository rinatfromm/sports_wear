package com.sportswear.sportswear.converter;

import com.sportswear.sportswear.dto.BasketDTO;
import com.sportswear.sportswear.entity.Basket;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasketDTOConverter {
    private final ModelMapper modelMapper;

    public Basket convertDTOToBasket(BasketDTO basketDTO) {
        return modelMapper.map(basketDTO, Basket.class);
    }

    public BasketDTO convertBasketToDTO(Basket basket) {
        return modelMapper.map(basket, BasketDTO.class);
    }
}
