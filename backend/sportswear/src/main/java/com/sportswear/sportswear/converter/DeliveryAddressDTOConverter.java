package com.sportswear.sportswear.converter;

import com.sportswear.sportswear.dto.DeliveryAddressDTO;
import com.sportswear.sportswear.entity.DeliveryAddress;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DeliveryAddressDTOConverter {
    private final ModelMapper modelMapper;

    public DeliveryAddress convertDTOToDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO) {
        return modelMapper.map(deliveryAddressDTO, DeliveryAddress.class);
    }

    public DeliveryAddressDTO convertDeliveryAddressToDTO(DeliveryAddress deliveryAddress) {
        return modelMapper.map(deliveryAddress, DeliveryAddressDTO.class);
    }

    public List<DeliveryAddressDTO> convertDeliveryAddressesToDTOs(List<DeliveryAddress> deliveryAddresses) {
        List<DeliveryAddressDTO> deliveryAddressDTOs = new LinkedList<>();
        for (DeliveryAddress deliveryAddress : deliveryAddresses) {
            deliveryAddressDTOs.add(modelMapper.map(deliveryAddress, DeliveryAddressDTO.class));
        }
        return deliveryAddressDTOs;
    }
}
