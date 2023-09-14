package com.example.appbank2.repository;
import com.example.appbank2.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveProduct() {
        // Создаем новый продукт
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(100.0);

        // Сохраняем в репозиторий
        Product savedProduct = productRepository.save(product);

        // Проверяем, что продукт успешно сохранен
        assertTrue(savedProduct.getId() > 0);
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getPrice(), savedProduct.getPrice());
    }

    @Test
    void testFindAllProducts() {
        // Получаем все продукты из репозитория
        List<Product> products = productRepository.findAll();

        // Проверяем, что список не пустой
        assertTrue(products.size() > 0);
    }

    @Test
    void testFindProductById() {
        // Создаем новый продукт
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(100.0);

        // Сохраняем в репозиторий
        Product savedProduct = productRepository.save(product);

        // Ищем продукт по ID
        Product foundProduct = productRepository.findById(savedProduct.getId()).orElse(null);

        // Проверяем, что продукт успешно найден
        assertEquals(savedProduct, foundProduct);
    }

    @Test
    void testDeleteProduct() {
        // Создаем новый продукт
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(100.0);

        // Сохраняем в репозиторий
        Product savedProduct = productRepository.save(product);

        // Удаляем продукт
        productRepository.deleteById(savedProduct.getId());

        // Проверяем, что продукт больше не существует
        assertTrue(productRepository.findById(savedProduct.getId()).isEmpty());
    }
}
