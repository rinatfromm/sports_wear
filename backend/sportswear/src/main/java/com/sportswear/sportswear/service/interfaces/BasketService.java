package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.BasketDTO;

import java.util.UUID;

public interface BasketService {
    void createBasket(BasketDTO basketDTO);
    BasketDTO getBasketById(UUID id);
    void updateBasketById(BasketDTO basketDTO);
}
