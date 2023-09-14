package com.example.appbank2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Класс представляет сущность "Договор" в базе данных.
 */
@Entity
@Table(name = "agreements")
@Data
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "sum", precision = 15, scale = 2)
    private BigDecimal sum;

    @Column(name = "interest_rate", precision = 4, scale = 2)
    private BigDecimal interestRate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Устанавливает имя договора.
     *
     * @param agreementName Название договора.
     */
    public void setName(String agreementName) {
        // Реализация метода
    }

    /**
     * Получает имя договора.
     *
     * @return Название договора.
     */
    public String getName() {
        return null; // Реализация метода
    }

    /**
     * Устанавливает детали договора.
     *
     * @param agreementDetails Детали договора.
     */
    public void setDetails(String agreementDetails) {
        // Реализация метода
    }

    /**
     * Устанавливает тип договора.
     *
     * @param agreementType Тип договора.
     */
    public void setType(String agreementType) {
        // Реализация метода
    }

    /**
     * Получает детали договора.
     *
     * @return Детали договора.
     */
    public short getDetails() {
        return 0; // Реализация метода
    }

    /**
     * Получает тип договора.
     *
     * @return Тип договора.
     */
    public short getType() {
        return 0; // Реализация метода
    }
}

