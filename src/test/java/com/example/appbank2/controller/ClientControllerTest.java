package com.example.appbank2.controller;
import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClientControllerTest {

    @Mock
    private ClientService clientService;

    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientController = new ClientController(clientService);
    }

    @Test
    void testGetAllClients() {
        // Arrange
        List<ClientDto> clients = Arrays.asList(new ClientDto(), new ClientDto());
        when(clientService.getAllClientDTO()).thenReturn(clients);

        // Act
        ResponseEntity<List<ClientDto>> response = clientController.getAllClients();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clients, response.getBody());
    }

    @Test
    void testGetClientById() {
        // Arrange
        Long clientId = 1L;
        ClientDto client = new ClientDto();
        when(clientService.getClientDtoById(clientId)).thenReturn(client);

        // Act
        ResponseEntity<ClientDto> response = clientController.getClientById(clientId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(client, response.getBody());
    }

    @Test
    void testGetClientById_NotFound() {
        // Arrange
        Long clientId = 1L;
        when(clientService.getClientDtoById(clientId)).thenReturn(null);

        // Act
        ResponseEntity<ClientDto> response = clientController.getClientById(clientId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
