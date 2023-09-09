package com.example.appbank2.service;

import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client createClient(Client client);

    Object getAlL();
    void create(ClientDto clientDto);

    List<ClientDto> getAllClientDTO();

    ClientDto getClientDtoById(Long id);

}
