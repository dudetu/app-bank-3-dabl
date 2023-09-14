package com.example.appbank2.service;

import com.example.appbank2.entity.Account;
import com.example.appbank2.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.appbank2.repository.AccountRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса AccountService.
 */
@Service
public class AccountServiceImpl implements AccountService {

    /**
     * Репозиторий для работы с данными счетов.
     */
    private final AccountRepository accountRepository;

    /**
     * Конструктор класса, принимающий репозиторий счетов.
     *
     * @param accountRepository Репозиторий для работы с данными счетов.
     */
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Получает список всех счетов.
     *
     * @return Список объектов типа Account.
     */
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Получает счет по его идентификатору.
     *
     * @param id Идентификатор счета.
     * @return Объект типа Account или null, если счет не найден.
     * @throws DataNotFoundException если счет не найден.
     */
    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("account not found"));
    }

    /**
     * Создает новый счет.
     *
     * @param account Объект типа Account, представляющий новый счет.
     * @return Созданный счет.
     */
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    /**
     * Обновляет информацию о счете.
     *
     * @param id     Идентификатор счета, который нужно обновить.
     * @param update Обновленные данные о счете.
     */
    @Override
    @Transactional
    public void updateAccount(Long id, Account update) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("account not found"));
        Account updatedAccount = updateFields(update, account);
        accountRepository.save(updatedAccount);
    }

    /**
     * Обновляет поля счета на основе новых данных.
     *
     * @param update  Новые данные о счете.
     * @param account Существующий счет.
     * @return Обновленный счет.
     */
    private Account updateFields(Account update, Account account) {
        // ... (Здесь описать обновление полей)
        return account;
    }
}
