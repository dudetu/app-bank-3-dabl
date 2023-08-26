package com.example.appbank2.converter;

import com.example.appbank2.dto.ClientCreateDto;
import com.example.appbank2.dto.ClientrDto;
import com.example.appbank2.entity.Client;
import org.apache.catalina.User;

public class ClientConverterimpl {

    ClientrDto toDto(Client client) {
        return new ClientrDto(client.getName(), client.getEmaile);
    }

    public Object toEntity(ClientCreateDto userDto) {

        return new Client(userDto.getName(), userDto.getEmail());
    }
}
