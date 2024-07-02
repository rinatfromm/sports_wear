package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ClientDTOConverter;
import com.sportswear.sportswear.dto.ClientDTO;
import com.sportswear.sportswear.repository.ClientRepository;
import com.sportswear.sportswear.service.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientDTOConverter clientDTOConverter;

    @Override
    public void createClient(ClientDTO clientDTO) {
        clientRepository.save(clientDTOConverter.convertDTOToClient(clientDTO));
        log.info("Create bank info.");
    }

    @Override
    public ClientDTO getClient() {
        return null;
    }

    @Override
    public void updateClient(ClientDTO clientDTO) {

    }
}