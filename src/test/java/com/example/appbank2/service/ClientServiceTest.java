package com.example.appbank2.service;

import com.example.appbank2.entity.Client;
import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.exception.DataNotFoundException;
import com.example.appbank2.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

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

    @Test
    void testGetClientByIdNotFound() {
        // Arrange
        Long clientId = 1L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(DataNotFoundException.class, () -> clientService.getClientById(clientId));
    }

    @Test
    void testCreateClient() {
        // Arrange
        Client client = new Client();

        // Act
        Client result = clientService.createClient(client);

        // Assert
        verify(clientRepository).save(client);
        assertThat(result).isEqualTo(client);
    }

    @Test
    void testCreateClientDto() {
        // Arrange
        ClientDto clientDto = new ClientDto();
        Client client = new Client();
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        // Act
        clientService.create(clientDto);

        // Assert
        verify(clientRepository).save(any(Client.class));
    }

    @Test
    void testGetAllClientDTO() {
        // Arrange
        when(clientRepository.findAll()).thenReturn(List.of(
                new Client(), new Client()
        ));

        // Act
        List<ClientDto> clientDtos = clientService.getAllClientDTO();

        // Assert
        assertThat(clientDtos).hasSize(2);
    }

    @Test
    void testGetClientDtoById() {
        // Arrange
        Long clientId = 1L;
        Client client = new Client();
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

        // Act
        ClientDto result = clientService.getClientDtoById(clientId);

        // Assert
        assertThat(result).isNotNull();
    }

    @Test
    void testGetClientDtoByIdNotFound() {
        // Arrange
        Long clientId = 1L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        // Act
        ClientDto result = clientService.getClientDtoById(clientId);

        // Assert
        assertThat(result).isNull();
    }
}
