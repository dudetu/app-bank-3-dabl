package com.example.appbank2.service;

import com.example.appbank2.converter.ClientConverter;
import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.appbank2.repository.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter converter;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientConverter converter) {
        this.clientRepository = clientRepository;
        this.converter = converter;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Object getAlL() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void create(ClientDto clientDto) {
        Client client = converter.dtoToEntity(clientDto);
        clientRepository.save(client);
    }

    @Override
    public List<ClientDto> getAllClientDTO() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> clientDtos = clients.stream()
                .map(client -> converter.entityToDto(client))
                .toList();
        return clientDtos;
    }

    @Override
    public ClientDto getClientDtoById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        ClientDto clientDto = converter.entityToDto(client);
        return clientDto;
    }


}

