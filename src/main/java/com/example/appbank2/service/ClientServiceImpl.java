package com.example.appbank2.service;

import com.example.appbank2.converter.ClientConverter;
import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.entity.Client;
import com.example.appbank2.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса ClientService, предоставляющая методы для работы с клиентами.
 */
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter converter;

    /**
     * Конструктор класса ClientServiceImpl.
     *
     * @param clientRepository Репозиторий клиентов.
     * @param converter        Конвертер для преобразования между сущностью и DTO клиента.
     */
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientConverter converter) {
        this.clientRepository = clientRepository;
        this.converter = converter;
    }

    /**
     * Получает всех клиентов.
     *
     * @return Список всех клиентов.
     */
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Получает клиента по его ID.
     *
     * @param id ID клиента.
     * @return Клиент с указанным ID или null, если не найден.
     */
    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    /**
     * Создает нового клиента.
     *
     * @param client Новый клиент.
     * @return Созданный клиент.
     */
    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Получает все данные.
     *
     * @return Все данные.
     */
    @Override
    public Object getAlL() {
        return clientRepository.findAll();
    }

    /**
     * Создает нового клиента на основе данных из DTO.
     *
     * @param clientDto DTO с данными клиента.
     */
    @Override
    @Transactional
    public void create(ClientDto clientDto) {
        Client client = converter.dtoToEntity(clientDto);
        clientRepository.save(client);
    }

    /**
     * Получает список DTO всех клиентов.
     *
     * @return Список DTO клиентов.
     */
    @Override
    public List<ClientDto> getAllClientDTO() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> clientDtos = clients.stream()
                .map(client -> converter.entityToDto(client))
                .toList();
        return clientDtos;
    }

    /**
     * Получает DTO клиента по его ID.
     *
     * @param id ID клиента.
     * @return DTO клиента с указанным ID или null, если не найден.
     */
    @Override
    public ClientDto getClientDtoById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        ClientDto clientDto = converter.entityToDto(client);
        return clientDto;
    }
}
