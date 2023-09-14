package com.example.appbank2.repository;

import com.example.appbank2.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testSaveClient() {
        // Создаем нового клиента
        Client client = new Client();
        client.setName("John Doe");
        client.setEmail("john.doe@example.com");

        // Сохраняем в репозиторий
        Client savedClient = clientRepository.save(client);

        // Проверяем, что клиент успешно сохранен
        assertTrue(savedClient.getId() > 0);
        assertEquals((Short) client.getName(), savedClient.getName());
        assertEquals(client.getEmail(), savedClient.getEmail());
    }

    @Test
    void testFindAllClients() {
        // Получаем всех клиентов из репозитория
        List<Client> clients = clientRepository.findAll();

        // Проверяем, что список не пустой
        assertTrue(clients.size() > 0);
    }

    @Test
    void testFindClientById() {
        // Создаем нового клиента
        Client client = new Client();
        client.setName("Jane Doe");
        client.setEmail("jane.doe@example.com");

        // Сохраняем в репозиторий
        Client savedClient = clientRepository.save(client);

        // Ищем клиента по ID
        Client foundClient = clientRepository.findById(savedClient.getId()).orElse(null);

        // Проверяем, что клиент успешно найден
        assertEquals(savedClient, foundClient);
    }

    @Test
    void testDeleteClient() {
        // Создаем нового клиента
        Client client = new Client();
        client.setName("Jim Doe");
        client.setEmail("jim.doe@example.com");

        // Сохраняем в репозиторий
        Client savedClient = clientRepository.save(client);

        // Удаляем клиента
        clientRepository.deleteById(savedClient.getId());

        // Проверяем, что клиент больше не существует
        assertTrue(clientRepository.findById(savedClient.getId()).isEmpty());
    }
}
