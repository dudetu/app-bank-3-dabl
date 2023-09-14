package com.example.appbank2.service;

import com.example.appbank2.entity.Manager;

import java.util.List;

/**
 * Интерфейс для работы с сущностью "Менеджер".
 */
public interface ManagerService {

    /**
     * Получает список всех менеджеров.
     *
     * @return Список менеджеров.
     */
    List<Manager> getAllManagers();

    /**
     * Получает менеджера по его идентификатору.
     *
     * @param id Идентификатор менеджера.
     * @return Менеджер с указанным идентификатором, или null, если не найден.
     */
    Manager getManagerById(Long id);

    /**
     * Создает нового менеджера.
     *
     * @param manager Новый менеджер.
     * @return Созданный менеджер.
     */
    Manager createManager(Manager manager);
}
