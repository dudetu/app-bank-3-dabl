package com.example.appbank2.converter;

import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConverterImpl implements ClientConverter {
    @Override
    public ClientDto entityToDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setFullname(client.getFirstName() + " " + client.getLastName());
        clientDto.setEmail(client.getEmail());
        return clientDto;
    }

    @Override
    public Client dtoToEntity(ClientDto clientDto) {
        Client client = new Client();
        String[] strings = clientDto.getFullname().split(" ");
        client.setFirstName(strings[0]);
        client.setLastName(strings[1]);
        client.setEmail(clientDto.getEmail());
        return client;
    }
}
