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
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientDTOConverter clientDTOConverter;

    @Override
    @Transactional
    public ClientDTO createClient(@RequestBody @Valid ClientDTO clientDTO) {
        Client client = clientRepository.save(clientDTOConverter.convertDTOToClient(clientDTO));
        log.info("Create client.");
        return clientDTOConverter.convertClientToDTO(client);
    }

    @Override
    @Transactional
    public ClientDTO getClientById(UUID id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Client does not exist!"));
        log.info("Get client by id." + id);
        return clientDTOConverter.convertClientToDTO(client);
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
    public ClientDTO updateClient(@RequestBody @Valid ClientDTO clientDTO) {
        if (!clientRepository.existsById(clientDTO.getId())) {
            new NoSuchElementException("Could not update non existing client!");
        }
        Client client = clientRepository.save(clientDTOConverter.convertDTOToClient(clientDTO));
        log.info("Update client.");
        return clientDTOConverter.convertClientToDTO(client);
    }

    @Override
    @Transactional
    public String deleteClientById(UUID id) {
        if (!clientRepository.existsById(id)) {
            new NoSuchElementException("Could not delete non existing client! id " + id);
        }
        clientRepository.deleteById(id);
        return "Client deleted! id " + id;
    }
}