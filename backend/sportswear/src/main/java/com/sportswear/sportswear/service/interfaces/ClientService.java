package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.ClientDTO;

public interface ClientService {
    void createClient(ClientDTO clientDTO);
    ClientDTO getClient();
    void updateClient(ClientDTO clientDTO);
}