package com.example.appbank2.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Класс представляет сущность "Менеджер" в базе данных.
 */
@Entity
@Table(name = "managers")
@Data
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Устанавливает имя менеджера.
     *
     * @param managerName Имя менеджера.
     */
    public void setName(String managerName) {
        // Реализация метода
    }

    /**
     * Устанавливает электронную почту менеджера.
     *
     * @param email Адрес электронной почты менеджера.
     */
    public void setEmail(String email) {
        // Реализация метода
    }

    /**
     * Получает имя менеджера.
     *
     * @return Имя менеджера.
     */
    public short getName() {
        return 0; // Реализация метода
    }

    /**
     * Получает адрес электронной почты менеджера.
     *
     * @return Адрес электронной почты менеджера.
     */
    public short getEmail() {
        return 0; // Реализация метода
    }
}

