package com.example.appbank2.service;
import com.example.appbank2.entity.Account;
import com.example.appbank2.exception.DataNotFoundException;
import com.example.appbank2.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        when(accountRepository.findAll()).thenReturn(accounts);

        List<Account> result = accountService.getAllAccounts();

        assertThat(result).isEqualTo(accounts);
    }

    @Test
    void testGetAccountById() {
        Long accountId = 1L;
        Account account = new Account();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));

        Account result = accountService.getAccountById(accountId);

        assertThat(result).isEqualTo(account);
    }

    @Test
    void testGetAccountByIdNotFound() {
        Long accountId = 1L;
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        // Проверяем, что вызывается исключение DataNotFoundException
        try {
            accountService.getAccountById(accountId);
        } catch (DataNotFoundException e) {
            assertThat(e.getMessage()).isEqualTo("account not found");
        }
    }

    @Test
    void testCreateAccount() {
        Account account = new Account();
        when(accountRepository.save(account)).thenReturn(account);

        Account result = accountService.createAccount(account);

        assertThat(result).isEqualTo(account);
    }

    @Test
    void testUpdateAccount() {
        Long accountId = 1L;
        Account existingAccount = new Account();
        existingAccount.setId(accountId);

        Account updatedAccount = new Account();
        updatedAccount.setName("Updated Name");

        when(accountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));
        when(accountRepository.save(existingAccount)).thenReturn(existingAccount);

        accountService.updateAccount(accountId, updatedAccount);

        assertThat(existingAccount.getName()).isEqualTo(updatedAccount.getName());
    }

    @Test
    void testUpdateAccountNotFound() {
        Long accountId = 1L;
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        // Проверяем, что вызывается исключение DataNotFoundException
        try {
            accountService.updateAccount(accountId, new Account());
        } catch (DataNotFoundException e) {
            assertThat(e.getMessage()).isEqualTo("account not found");
        }
    }
}

