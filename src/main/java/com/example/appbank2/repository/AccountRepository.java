package com.example.appbank2.repository;

import com.example.appbank2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью "Account".
 * Интерфейс расширяет JpaRepository, предоставляя базовые операции работы с базой данных.
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {


}

