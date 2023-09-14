package com.example.appbank2.service;
import com.example.appbank2.entity.Manager;
import com.example.appbank2.exception.DataNotFoundException;
import com.example.appbank2.repository.ManagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class ManagerServiceImplTest {

    @Mock
    private ManagerRepository managerRepository;

    @InjectMocks
    private ManagerServiceImpl managerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllManagers() {
        // Arrange
        when(managerRepository.findAll()).thenReturn(List.of(
                new Manager(), new Manager()
        ));

        // Act
        List<Manager> managers = managerService.getAllManagers();

        // Assert
        assertThat(managers).hasSize(2);
    }

    @Test
    void testGetManagerById_ExistingManager() {
        // Arrange
        Long managerId = 1L;
        Manager manager = new Manager();
        when(managerRepository.findById(managerId)).thenReturn(Optional.of(manager));

        // Act
        Manager result = managerService.getManagerById(managerId);

        // Assert
        assertThat(result).isEqualTo(manager);
    }

    @Test
    void testGetManagerById_NonExistingManager() {
        // Arrange
        Long managerId = 1L;
        when(managerRepository.findById(managerId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> managerService.getManagerById(managerId))
                .isInstanceOf(DataNotFoundException.class);
    }

    @Test
    void testCreateManager() {
        // Arrange
        Manager manager = new Manager();
        when(managerRepository.save(manager)).thenReturn(manager);

        // Act
        Manager result = managerService.createManager(manager);

        // Assert
        assertThat(result).isEqualTo(manager);
    }
}
