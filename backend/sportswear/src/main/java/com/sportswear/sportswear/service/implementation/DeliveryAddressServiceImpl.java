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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final DeliveryAddressDTOConverter deliveryAddressDTOConverter;

    @Override
    @Transactional
    public DeliveryAddressDTO createDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO) {
        DeliveryAddress deliveryAddress = deliveryAddressRepository
                .save(deliveryAddressDTOConverter.convertDTOToDeliveryAddress(deliveryAddressDTO));
        log.info("Create delivery address.");
        return deliveryAddressDTOConverter.convertDeliveryAddressToDTO(deliveryAddress);
    }

    @Override
    @Transactional
    public DeliveryAddressDTO getDeliveryAddressById(UUID id) {
        DeliveryAddress deliveryAddress = deliveryAddressRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("DeliveryAddress does not exist!"));
        log.info("Get delivery address by id." + id);
        return deliveryAddressDTOConverter.convertDeliveryAddressToDTO(deliveryAddress);
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
    public DeliveryAddressDTO updateDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO) {
        if (!deliveryAddressRepository.existsById(deliveryAddressDTO.getId())) {
            new NoSuchElementException("COuld not update non existing delivery address!");
        }
        DeliveryAddress deliveryAddress = deliveryAddressRepository
                .save(deliveryAddressDTOConverter.convertDTOToDeliveryAddress(deliveryAddressDTO));
        log.info("Update delivery address.");
        return deliveryAddressDTOConverter.convertDeliveryAddressToDTO(deliveryAddress);
    }

    @Override
    @Transactional
    public String deleteDeliveryAddressById(UUID id) {
        if (!deliveryAddressRepository.existsById(id)) {
            new NoSuchElementException("Could not delete non existing delivery address! id " + id);
        }
        return "Delivery address deleted! id " + id;
    }
}
