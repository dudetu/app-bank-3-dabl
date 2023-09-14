package com.example.appbank2.converter;

import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.entity.Client;
import org.springframework.stereotype.Component;

/**
 * Реализация интерфейса ClientConverter для преобразования между объектами Client и ClientDto.
 */
@Component
public class ClientConverterImpl implements ClientConverter {

    /**
     * Преобразует объект Client в ClientDto.
     *
     * @param client Объект Client для преобразования
     * @return Соответствующий объект ClientDto
     */
    @Override
    public ClientDto entityToDto(Client client) {
        ClientDto clientDto = new ClientDto(1L, "John Doe");
        clientDto.setFullname(client.getFirstName() + " " + client.getLastName());
        clientDto.setEmail(client.getEmail());
        return clientDto;
    }

    /**
     * Преобразует объект ClientDto в Client.
     *
     * @param clientDto Объект ClientDto для преобразования
     * @return Соответствующий объект Client
     */
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

