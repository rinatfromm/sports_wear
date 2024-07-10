package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.DeliveryAddressDTOConverter;
import com.sportswear.sportswear.dto.DeliveryAddressDTO;
import com.sportswear.sportswear.entity.DeliveryAddress;
import com.sportswear.sportswear.repository.DeliveryAddressRepository;
import com.sportswear.sportswear.service.interfaces.DeliveryAddressService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final DeliveryAddressDTOConverter deliveryAddressDTOConverter;

    @Override
    @Transactional
    public void createDeliveryAddress(@RequestBody @Valid DeliveryAddressDTO deliveryAddressDTO) {
        deliveryAddressRepository.save(deliveryAddressDTOConverter.convertDTOToDeliveryAddress(deliveryAddressDTO));
        log.info("Create delivery address info.");
    }

    @Override
    @Transactional
    public DeliveryAddressDTO getDeliveryAddressById(UUID id) {
        log.info("Get delivery address by id.");
        return deliveryAddressDTOConverter.convertDeliveryAddressToDTO(deliveryAddressRepository.findAllById(id));
    }

    @Override
    @Transactional
    public List<DeliveryAddressDTO> getAllDeliveryAddresses() {
        List<DeliveryAddress> deliveryAddresses = deliveryAddressRepository.findAll();
        log.info("Get all delivery addresses.");
        return deliveryAddressDTOConverter.convertDeliveryAddressesToDTOs(deliveryAddresses);
    }

    @Override
    @Transactional
    public void updateDeliveryAddressById(@RequestBody @Valid DeliveryAddressDTO deliveryAddressDTO) {
        DeliveryAddress deliveryAddress = deliveryAddressDTOConverter.convertDTOToDeliveryAddress(deliveryAddressDTO);
        deliveryAddressRepository.save(deliveryAddress);
        log.info("Update delivery address by id.");
    }
}
