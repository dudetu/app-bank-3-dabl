package com.example.appbank2.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Класс представляет сущность "Транзакция" в базе данных.
 */
@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(name = "recipient_id")
    private Long recipientId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    /**
     * Получает тип транзакции.
     *
     * @return Тип транзакции.
     */
    public String getType() {
        return type;
    }

    /**
     * Устанавливает тип транзакции.
     *
     * @param type Тип транзакции.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Получает сумму транзакции.
     *
     * @return Сумма транзакции.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Устанавливает сумму транзакции.
     *
     * @param amount Сумма транзакции.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Получает описание транзакции.
     *
     * @return Описание транзакции.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает описание транзакции.
     *
     * @param description Описание транзакции.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Получает ID отправителя транзакции.
     *
     * @return ID отправителя транзакции.
     */
    public Long getSenderId() {
        return senderId;
    }

    /**
     * Устанавливает ID отправителя транзакции.
     *
     * @param senderId ID отправителя транзакции.
     */
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    /**
     * Получает ID получателя транзакции.
     *
     * @return ID получателя транзакции.
     */
    public Long getRecipientId() {
        return recipientId;
    }

    /**
     * Устанавливает ID получателя транзакции.
     *
     * @param recipientId ID получателя транзакции.
     */
    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    /**
     * Получает временную метку создания транзакции.
     *
     * @return Временная метка создания транзакции.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
