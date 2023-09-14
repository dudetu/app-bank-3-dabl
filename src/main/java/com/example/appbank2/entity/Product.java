package com.example.appbank2.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Класс представляет сущность "Продукт" в базе данных.
 */
@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "interest_rate", precision = 4, scale = 2)
    private BigDecimal interestRate;

    @Column(name = "limits", precision = 12, scale = 2)
    private BigDecimal limits;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Устанавливает цену продукта.
     *
     * @param price Цена продукта.
     */
    public void setPrice(double price) {
        // Реализация метода
    }

    /**
     * Получает цену продукта.
     *
     * @return Цена продукта.
     */
    public short getPrice() {
        return 0; // Реализация метода
    }
}
