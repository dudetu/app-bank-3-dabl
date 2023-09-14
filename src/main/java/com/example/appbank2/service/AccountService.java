package com.example.appbank2.service;

import com.example.appbank2.entity.Account;

import java.util.List;
/**
 * Сервис для работы с сущностью "Account".
 */
public interface AccountService {

    /**
     * Получает список всех счетов.
     *
     * @return Список объектов типа Account.
     */
    List<Account> getAllAccounts();

    /**
     * Получает счет по его идентификатору.
     *
     * @param id Идентификатор счета.
     * @return Объект типа Account или null, если счет не найден.
     */
    Account getAccountById(Long id);

    /**
     * Создает новый счет.
     *
     * @param account Объект типа Account, представляющий новый счет.
     * @return Созданный счет.
     */
    Account createAccount(Account account);

    /**
     * Обновляет информацию о счете.
     *
     * @param id     Идентификатор счета, который нужно обновить.
     * @param update Обновленные данные о счете.
     */
    void updateAccount(Long id, Account update);
}


