package com.example.appbank2.repository;
import com.example.appbank2.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testSaveAccount() {
        // Создаем новый аккаунт
        Account account = new Account();
        account.setName("Test Account");
        account.setType("Savings");
        account.setStatus("Active");
        account.setEmail("test@example.com");
        account.setBalance(new BigDecimal("1000.00"));
        account.setCurrencyCode("USD");

        // Сохраняем в репозиторий
        Account savedAccount = accountRepository.save(account);

        // Проверяем, что аккаунт успешно сохранен
        assertTrue(savedAccount.getId() > 0);
        assertEquals(account.getName(), savedAccount.getName());
        assertEquals(account.getType(), savedAccount.getType());
        assertEquals(account.getStatus(), savedAccount.getStatus());
        assertEquals(account.getEmail(), savedAccount.getEmail());
        assertEquals(account.getBalance(), savedAccount.getBalance());
        assertEquals(account.getCurrencyCode(), savedAccount.getCurrencyCode());
    }

    @Test
    void testFindAllAccounts() {
        // Получаем все аккаунты из репозитория
        List<Account> accounts = accountRepository.findAll();

        // Проверяем, что список не пустой
        assertTrue(accounts.size() > 0);
    }

    @Test
    void testFindAccountById() {
        // Создаем новый аккаунт
        Account account = new Account();
        account.setName("Test Account");
        account.setType("Savings");
        account.setStatus("Active");
        account.setEmail("test@example.com");
        account.setBalance(new BigDecimal("1000.00"));
        account.setCurrencyCode("USD");

        // Сохраняем в репозиторий
        Account savedAccount = accountRepository.save(account);

        // Ищем аккаунт по ID
        Account foundAccount = accountRepository.findById(savedAccount.getId()).orElse(null);

        // Проверяем, что аккаунт успешно найден
        assertEquals(savedAccount, foundAccount);
    }

    @Test
    void testDeleteAccount() {
        // Создаем новый аккаунт
        Account account = new Account();
        account.setName("Test Account");
        account.setType("Savings");
        account.setStatus("Active");
        account.setEmail("test@example.com");
        account.setBalance(new BigDecimal("1000.00"));
        account.setCurrencyCode("USD");

        // Сохраняем в репозиторий
        Account savedAccount = accountRepository.save(account);

        // Удаляем аккаунт
        accountRepository.deleteById(savedAccount.getId());

        // Проверяем, что аккаунт больше не существует
        assertTrue(accountRepository.findById(savedAccount.getId()).isEmpty());
    }
}
