package com.example.appbank2.service;

import com.example.appbank2.entity.Transaction;

import java.util.List;

import com.example.appbank2.entity.Transaction;

import java.util.List;

/**
 * Интерфейс, предоставляющий методы для работы с транзакциями.
 */
public interface TransactionService {

    /**
     * Получить список всех транзакций.
     *
     * @return Список объектов Transaction.
     */
    List<Transaction> getAllTransactions();

    /**
     * Получить транзакцию по ее уникальному идентификатору.
     *
     * @param id Уникальный идентификатор транзакции.
     * @return Объект Transaction, если найден, в противном случае null.
     */
    Transaction getTransactionById(Long id);

    /**
     * Создать новую транзакцию.
     *
     * @param transaction Объект Transaction, который будет создан.
     * @return Созданный объект Transaction.
     */
    Transaction createTransaction(Transaction transaction);


}
