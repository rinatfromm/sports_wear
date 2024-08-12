package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.ClientDTO;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO getClientById(UUID id);
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(ClientDTO clientDTO);
    String deleteClientById(UUID id);
}