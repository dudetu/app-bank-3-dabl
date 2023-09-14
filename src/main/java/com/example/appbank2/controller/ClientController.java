package com.example.appbank2.controller;

import com.example.appbank2.dto.ClientDto;
import com.example.appbank2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления клиентами.
 */
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    /**
     * Конструктор контроллера.
     *
     * @param clientService Сервис управления клиентами.
     */
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Получает список всех клиентов.
     *
     * @return ResponseEntity со списком клиентов и статусом HTTP.
     */
    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> clients = clientService.getAllClientDTO();
        return ResponseEntity.ok(clients);
    }

    /**
     * Получает клиента по его идентификатору.
     *
     * @param id Идентификатор клиента.
     * @return ResponseEntity с клиентом и статусом HTTP.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        ClientDto client = clientService.getClientDtoById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Создает нового клиента.
     *
     * @param clientDto Данные нового клиента.
     * @return ResponseEntity с сообщением об успешном создании и статусом HTTP.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createClient(@RequestBody ClientDto clientDto) {
        clientService.create(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
