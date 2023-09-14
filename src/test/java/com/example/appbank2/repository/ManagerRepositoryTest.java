package com.example.appbank2.repository;
import com.example.appbank2.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    void testSaveManager() {
        // Создаем нового менеджера
        Manager manager = new Manager();
        manager.setName("John Doe");
        manager.setEmail("john.doe@example.com");

        // Сохраняем в репозиторий
        Manager savedManager = managerRepository.save(manager);

        // Проверяем, что менеджер успешно сохранен
        assertTrue(savedManager.getId() > 0);
        assertEquals(manager.getName(), savedManager.getName());
        assertEquals(manager.getEmail(), savedManager.getEmail());
    }

    @Test
    void testFindAllManagers() {
        // Получаем всех менеджеров из репозитория
        List<Manager> managers = managerRepository.findAll();

        // Проверяем, что список не пустой
        assertTrue(managers.size() > 0);
    }

    @Test
    void testFindManagerById() {
        // Создаем нового менеджера
        Manager manager = new Manager();
        manager.setName("Jane Doe");
        manager.setEmail("jane.doe@example.com");

        // Сохраняем в репозиторий
        Manager savedManager = managerRepository.save(manager);

        // Ищем менеджера по ID
        Manager foundManager = managerRepository.findById(savedManager.getId()).orElse(null);

        // Проверяем, что менеджер успешно найден
        assertEquals(savedManager, foundManager);
    }

    @Test
    void testDeleteManager() {
        // Создаем нового менеджера
        Manager manager = new Manager();
        manager.setName("Jim Doe");
        manager.setEmail("jim.doe@example.com");

        // Сохраняем в репозиторий
        Manager savedManager = managerRepository.save(manager);

        // Удаляем менеджера
        managerRepository.deleteById(savedManager.getId());

        // Проверяем, что менеджер больше не существует
        assertTrue(managerRepository.findById(savedManager.getId()).isEmpty());
    }
}
