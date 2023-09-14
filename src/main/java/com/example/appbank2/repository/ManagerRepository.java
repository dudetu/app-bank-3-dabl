package com.example.appbank2.repository;

import com.example.appbank2.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью "Manager".
 * Интерфейс расширяет JpaRepository, предоставляя базовые операции работы с базой данных.
 *
 */
public interface ManagerRepository extends JpaRepository<Manager, Long> {


}


