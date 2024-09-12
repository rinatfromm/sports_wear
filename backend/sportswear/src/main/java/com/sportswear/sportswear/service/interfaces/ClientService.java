package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.*;

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
    ClientGetDTO getClientById(UUID id);
    List<ClientGetDTO> getAllClients();
    List<OrderGetDTO> getAllOrders();
    ClientGetDTO updateClient(ClientGetDTO clientDTO);
    String deleteClientById(UUID id);
}