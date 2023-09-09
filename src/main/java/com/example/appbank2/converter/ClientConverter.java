package com.example.appbank2.converter;

import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.entity.Client;

public interface ClientConverter {

    ClientDto entityToDto(Client client);

    Client dtoToEntity(ClientDto clientDto);

}
