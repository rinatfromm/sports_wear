package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.*;
import com.sportswear.sportswear.entity.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientDTO createClient(ClientDTO clientDTO);
    void addDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO);
    void deleteDeliveryAddress(UUID id);
    void addOrder(OrderDTO orderDTO);
    void deleteOrder(UUID id);
    void addItemToOrder(OrderItemDTO orderItemDTO);
    void deleteItemFromOrder(UUID id);
    ClientGetDTO getClientDTOById(UUID id);
    Client getClientById(UUID id);
    List<ClientGetDTO> getAllClients();
    List<OrderGetDTO> getAllOrders();
    ClientGetDTO updateClient(ClientGetDTO clientDTO);
    String deleteClientById(UUID id);
}