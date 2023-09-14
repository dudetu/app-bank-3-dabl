package com.example.appbank2.service;

import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.entity.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Интерфейс ClientService предоставляет методы для работы с клиентами.
 */
public interface ClientService {

    /**
     * Получает список всех клиентов.
     *
     * @return Список клиентов.
     */
    List<Client> getAllClients();

    /**
     * Получает клиента по указанному идентификатору.
     *
     * @param id Идентификатор клиента.
     * @return Клиент, если найден, иначе null.
     */
    Client getClientById(Long id);

    /**
     * Создает нового клиента.
     *
     * @param client Объект клиента для создания.
     * @return Созданный клиент.
     */
    Client createClient(Client client);

    /**
     * Получает все данные (возможно, подробности) о клиентах.
     *
     * @return Данные о клиентах.
     */
    Object getAlL();

    /**
     * Создает нового клиента на основе данных из объекта ClientDto.
     *
     * @param clientDto Объект с данными для создания клиента.
     */


    @Transactional
    void create(ClientDto clientDto);

    /**
     * Получает список DTO (Data Transfer Object) всех клиентов.
     *
     * @return Список DTO клиентов.
     */
    List<ClientDto> getAllClientDTO();

    /**
     * Получает DTO клиента по указанному идентификатору.
     *
     * @param id Идентификатор клиента.
     * @return DTO клиента, если найден, иначе null.
     */
    ClientDto getClientDtoById(Long id);
}
