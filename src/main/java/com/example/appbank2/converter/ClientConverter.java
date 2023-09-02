package com.example.appbank2.converter;

import com.example.appbank2.dto.ClientCreateDto;
import com.example.appbank2.dto.ClientrDto;

public interface ClientConverter {


   private ClientrDto toDto(Object client) {
        return null;

    }

    private ClientrDto toEntity(ClientCreateDto clientDto) { return null; }

    private  Object toDto() {
        return toDto(null);
    }

}
