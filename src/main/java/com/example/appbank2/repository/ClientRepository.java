package com.example.appbank2.repository;

import com.example.appbank2.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью "Client".
 * Интерфейс расширяет JpaRepository, предоставляя базовые операции работы с базой данных.
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}


