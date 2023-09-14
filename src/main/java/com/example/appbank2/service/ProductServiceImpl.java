package com.example.appbank2.service;

import com.example.appbank2.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.appbank2.repository.ProductRepository;

import java.util.List;

import com.example.appbank2.entity.Product;
import com.example.appbank2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализация интерфейса ProductService, предоставляющая методы для работы с продуктами.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     * Конструктор класса.
     *
     * @param productRepository Репозиторий продуктов.
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Получить список всех продуктов.
     *
     * @return Список объектов Product.
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Получить продукт по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор продукта.
     * @return Объект Product, если найден, в противном случае null.
     */
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Создать новый продукт.
     *
     * @param product Объект Product, который будет создан.
     * @return Созданный объект Product.
     */
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
