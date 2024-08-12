package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.DeliveryAddressDTO;

import java.util.List;
import java.util.UUID;

public interface DeliveryAddressService {
    DeliveryAddressDTO createDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO);
    DeliveryAddressDTO getDeliveryAddressById(UUID id);
    List<DeliveryAddressDTO> getAllDeliveryAddresses();
    DeliveryAddressDTO updateDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO);
    String deleteDeliveryAddressById(UUID id);
}
