package com.example.appbank2.controller;

import com.example.appbank2.entity.Manager;
import com.example.appbank2.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.appbank2.entity.Manager;
import com.example.appbank2.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    // Внедрение сервиса для работы с менеджерами
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    /**
     * Получение списка всех менеджеров
     *
     * @return ResponseEntity с списком менеджеров и статусом HTTP
     */
    @GetMapping("/all")
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = managerService.getAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    /**
     * Получение менеджера по его идентификатору
     *
     * @param id Идентификатор менеджера
     * @return ResponseEntity с менеджером и статусом HTTP
     */
    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
        Manager manager = managerService.getManagerById(id);
        if (manager != null) {
            return new ResponseEntity<>(manager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Создание нового менеджера
     *
     * @param manager Данные нового менеджера
     * @return ResponseEntity с созданным менеджером и статусом HTTP
     */
    @PostMapping
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        Manager createdManager = managerService.createManager(manager);
        return new ResponseEntity<>(createdManager, HttpStatus.CREATED);
    }
}
