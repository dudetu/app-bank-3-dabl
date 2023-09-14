package com.example.appbank2.service;

import com.example.appbank2.entity.Product;

import java.util.List;

import com.example.appbank2.entity.Product;

import java.util.List;

/**
 * Интерфейс, предоставляющий методы для работы с продуктами.
 */
public interface ProductService {

    /**
     * Получить список всех продуктов.
     *
     * @return Список объектов Product.
     */
    List<Product> getAllProducts();

    /**
     * Получить продукт по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор продукта.
     * @return Объект Product, если найден, в противном случае null.
     */
    Product getProductById(Long id);

    /**
     * Создать новый продукт.
     *
     * @param product Объект Product, который будет создан.
     * @return Созданный объект Product.
     */
    Product createProduct(Product product);
}


