package com.example.appbank2.service;

import com.example.appbank2.converter.ClientConverter;
import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.entity.Client;
import com.example.appbank2.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientConverter converter;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllClients() {
        // Arrange
        when(clientRepository.findAll()).thenReturn(List.of(
                new Client(), new Client()
        ));

        // Act
        List<Client> clients = clientService.getAllClients();

        // Assert
        assertThat(clients).hasSize(2);
    }

    @Test
    void testGetClientById() {
        // Arrange
        Long clientId = 1L;
        Client client = new Client();
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

        // Act
        Client result = clientService.getClientById(clientId);

        // Assert
        assertThat(result).isEqualTo(client);
    }

    // По аналогии с остальными методами, протестируйте оставшиеся методы.
}
