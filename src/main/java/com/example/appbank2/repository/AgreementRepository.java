package com.example.appbank2.repository;

import com.example.appbank2.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью "Agreement".
 * Интерфейс расширяет JpaRepository, предоставляя базовые операции работы с базой данных.
 *
 */
public interface AgreementRepository extends JpaRepository<Agreement, Long> {

}

