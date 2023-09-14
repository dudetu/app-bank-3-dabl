package com.example.appbank2.repository;

import com.example.appbank2.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью "Transaction".
 * Интерфейс расширяет JpaRepository, предоставляя базовые операции работы с базой данных.
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}
