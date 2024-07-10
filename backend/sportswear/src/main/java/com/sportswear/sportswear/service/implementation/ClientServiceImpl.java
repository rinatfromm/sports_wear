package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ClientDTOConverter;
import com.sportswear.sportswear.dto.ClientDTO;
import com.sportswear.sportswear.entity.Client;
import com.sportswear.sportswear.repository.ClientRepository;
import com.sportswear.sportswear.service.interfaces.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientDTOConverter clientDTOConverter;

    @Override
    @Transactional
    public void createClient(@RequestBody @Valid ClientDTO clientDTO) {
        clientRepository.save(clientDTOConverter.convertDTOToClient(clientDTO));
        log.info("Create client.");
    }

    @Override
    @Transactional
    public ClientDTO getClientById(UUID id) {
        log.info("Get client by id.");
        return clientDTOConverter.convertClientToDTO(clientRepository.findAllById(id));
    }

    @Override
    @Transactional
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        log.info("Get all clients.");
        return clientDTOConverter.convertClientsToDTOs(clients);
    }

    @Override
    @Transactional
    public void updateClientById(@RequestBody @Valid ClientDTO clientDTO) {
        Client client = clientDTOConverter.convertDTOToClient(clientDTO);
        clientRepository.save(client);
        log.info("Update client by id.");
    }
}