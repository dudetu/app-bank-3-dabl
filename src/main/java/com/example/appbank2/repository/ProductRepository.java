package com.example.appbank2.repository;

import com.example.appbank2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью "Product".
 * Интерфейс расширяет JpaRepository, предоставляя базовые операции работы с базой данных.
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}

