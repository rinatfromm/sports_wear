package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.BasketDTOConverter;
import com.sportswear.sportswear.dto.BasketDTO;
import com.sportswear.sportswear.entity.Basket;
import com.sportswear.sportswear.repository.BasketRepository;
import com.sportswear.sportswear.service.interfaces.BasketService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketDTOConverter basketDTOConverter;

    @Override
    @Transactional
    public void createBasket(@RequestBody @Valid BasketDTO basketDTO) {
        basketRepository.save(basketDTOConverter.convertDTOToBasket(basketDTO));
        log.info("Create basket.");
    }

    @Override
    @Transactional
    public BasketDTO getBasketById(UUID id) {
        log.info("Get basket by id.");
        return basketDTOConverter.convertBasketToDTO(basketRepository.findAllById(id));
    }

    @Override
    @Transactional
    public void updateBasketById(@RequestBody @Valid BasketDTO basketDTO) {
        Basket basket = basketDTOConverter.convertDTOToBasket(basketDTO);
        basketRepository.save(basket);
        log.info("Update client by id.");
    }
}
