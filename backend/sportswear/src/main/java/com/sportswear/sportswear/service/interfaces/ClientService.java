package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.ClientDTO;
import com.sportswear.sportswear.dto.ClientGetDTO;
import com.sportswear.sportswear.dto.DeliveryAddressDTO;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientDTO createClient(ClientDTO clientDTO);
    void addDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO);
    void deleteDeliveryAddress(UUID id);
    ClientGetDTO getClientById(UUID id);
    List<ClientGetDTO> getAllClients();
    ClientGetDTO updateClient(ClientGetDTO clientDTO);
    String deleteClientById(UUID id);
}