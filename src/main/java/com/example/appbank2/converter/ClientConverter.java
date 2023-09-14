package com.example.appbank2.converter;

import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.entity.Client;

/**
 * Интерфейс для преобразования объектов типа Client в ClientDto и обратно.
 */
public interface ClientConverter {

    /**
     * Преобразовать объект Client в ClientDto.
     *
     * @param client Объект Client для преобразования
     * @return Соответствующий объект ClientDto
     */
    ClientDto entityToDto(Client client);

    /**
     * Преобразовать объект ClientDto в Client.
     *
     * @param clientDto Объект ClientDto для преобразования
     * @return Соответствующий объект Client
     */
    Client dtoToEntity(ClientDto clientDto);

}

