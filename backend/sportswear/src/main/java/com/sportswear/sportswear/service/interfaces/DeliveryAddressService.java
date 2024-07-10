package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.DeliveryAddressDTO;

import java.util.List;
import java.util.UUID;

public interface DeliveryAddressService {
    void createDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO);
    DeliveryAddressDTO getDeliveryAddressById(UUID id);
    List<DeliveryAddressDTO> getAllDeliveryAddresses();
    void updateDeliveryAddressById(DeliveryAddressDTO deliveryAddressDTO);
}
