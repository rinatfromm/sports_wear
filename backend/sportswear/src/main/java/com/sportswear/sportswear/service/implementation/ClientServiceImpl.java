package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ClientDTOConverter;
import com.sportswear.sportswear.converter.DeliveryAddressDTOConverter;
import com.sportswear.sportswear.dto.ClientDTO;
import com.sportswear.sportswear.dto.ClientGetDTO;
import com.sportswear.sportswear.dto.DeliveryAddressDTO;
import com.sportswear.sportswear.entity.Client;
import com.sportswear.sportswear.entity.DeliveryAddress;
import com.sportswear.sportswear.repository.ClientRepository;
import com.sportswear.sportswear.repository.DeliveryAddressRepository;
import com.sportswear.sportswear.service.interfaces.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientDTOConverter clientDTOConverter;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final DeliveryAddressDTOConverter deliveryAddressDTOConverter;

    @Override
    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientRepository.save(clientDTOConverter.convertDTOToClient(clientDTO));
        log.info("Create client.");
        return clientDTOConverter.convertClientToDTO(client);
    }

    @Override
    @Transactional
    public void addDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO) {
        Client client = clientRepository.findById(deliveryAddressDTO.getClient()).orElseThrow(
                () -> new NoSuchElementException("Client does not exist!"));
        DeliveryAddress newAddress = deliveryAddressDTOConverter.convertDTOToDeliveryAddress(deliveryAddressDTO);
        newAddress.setClient(client);
        newAddress = deliveryAddressRepository.save(newAddress);
        client.getDeliveryAddresses().add(newAddress);
        clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteDeliveryAddress(UUID id) {
        if(!deliveryAddressRepository.existsById(id)) {
            throw new NoSuchElementException("Delivery address does not exist!");
        }
        deliveryAddressRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ClientGetDTO getClientById(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found with ID: " + id));
        return clientDTOConverter.convertClientToGetDTO(client);
    }

    @Override
    @Transactional
    public List<ClientGetDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        log.info("Get all clients.");
        return clientDTOConverter.convertClientsToGetDTOs(clients);
    }

    @Override
    @Transactional
    public ClientGetDTO updateClient(ClientGetDTO clientDTO) {
        Client client = clientRepository.findById(clientDTO.getId())
                .orElseThrow(() -> new NoSuchElementException("Could not update non existing client!"));
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setMiddleName(clientDTO.getMiddleName());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        client.setBirthDate(clientDTO.getBirthDate());
        client = clientRepository.save(client);
        return clientDTOConverter.convertClientToGetDTO(client);
    }

    @Override
    @Transactional
    public String deleteClientById(UUID id) {
        if (!clientRepository.existsById(id)) {
            throw new NoSuchElementException("Could not delete non existing client! id " + id);
        }
        clientRepository.deleteById(id);
        return "Client deleted! id " + id;
    }
}