package com.example.appbank2.controller;
import com.example.appbank2.entity.Manager;
import com.example.appbank2.service.ManagerService;
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

class ManagerControllerTest {

    @Mock
    private ManagerService managerService;

    private ManagerController managerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        managerController = new ManagerController(managerService);
    }

    @Test
    void testGetAllManagers() {
        // Arrange
        List<Manager> managers = Arrays.asList(new Manager(), new Manager());
        when(managerService.getAllManagers()).thenReturn(managers);

        // Act
        ResponseEntity<List<Manager>> response = managerController.getAllManagers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(managers, response.getBody());
    }

    @Test
    void testGetManagerById() {
        // Arrange
        Long managerId = 1L;
        Manager manager = new Manager();
        when(managerService.getManagerById(managerId)).thenReturn(manager);

        // Act
        ResponseEntity<Manager> response = managerController.getManagerById(managerId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(manager, response.getBody());
    }

    @Test
    void testGetManagerById_NotFound() {
        // Arrange
        Long managerId = 1L;
        when(managerService.getManagerById(managerId)).thenReturn(null);

        // Act
        ResponseEntity<Manager> response = managerController.getManagerById(managerId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateManager() {
        // Arrange
        Manager manager = new Manager();
        when(managerService.createManager(manager)).thenReturn(manager);

        // Act
        ResponseEntity<Manager> response = managerController.createManager(manager);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(manager, response.getBody());
    }
}
