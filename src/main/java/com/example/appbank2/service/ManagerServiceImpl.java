package com.example.appbank2.service;

import com.example.appbank2.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.appbank2.repository.ManagerRepository;

import java.util.List;

/**
 * Реализация интерфейса ManagerService, предоставляющая методы для работы с менеджерами.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    /**
     * Конструктор класса ManagerServiceImpl.
     *
     * @param managerRepository Репозиторий для взаимодействия с данными о менеджерах.
     */
    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    /**
     * Получить список всех менеджеров.
     *
     * @return Список объектов Manager.
     */
    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    /**
     * Получить менеджера по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор менеджера.
     * @return Объект Manager, если найден, в противном случае null.
     */
    @Override
    public Manager getManagerById(Long id) {
        return managerRepository.findById(id).orElse(null);
    }

    /**
     * Создать нового менеджера.
     *
     * @param manager Объект Manager, который будет создан.
     * @return Созданный объект Manager.
     */
    @Override
    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }
}

