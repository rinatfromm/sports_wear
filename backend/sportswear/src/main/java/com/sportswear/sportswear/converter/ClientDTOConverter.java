package com.sportswear.sportswear.converter;

import com.sportswear.sportswear.dto.ClientDTO;
import com.sportswear.sportswear.entity.Client;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientDTOConverter {
    private final ModelMapper modelMapper;

    public Client convertDTOToClient(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    public ClientDTO convertClientToDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    public List<ClientDTO> convertClientsToDTOs(List<Client> clients) {
        List<ClientDTO> clientDTOs = new LinkedList<>();
        for (Client client : clients) {
            clientDTOs.add(modelMapper.map(client, ClientDTO.class));
        }
        return clientDTOs;
    }
}