package com.example.appbank2.service;

import com.example.appbank2.entity.Account;
import com.example.appbank2.exception.DataNotFoundException;
import com.example.appbank2.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAccounts() {
        // Arrange
        when(accountRepository.findAll()).thenReturn(List.of(
                new Account(), new Account()
        ));

        // Act
        List<Account> accounts = accountService.getAllAccounts();

        // Assert
        assertThat(accounts).hasSize(2);
    }

    @Test
    void testGetAccountById() {
        // Arrange
        Long accountId = 1L;
        Account account = new Account();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));

        // Act
        Account result = accountService.getAccountById(accountId);

        // Assert
        assertThat(result).isEqualTo(account);
    }

    @Test
    void testGetAccountByIdNotFound() {
        // Arrange
        Long accountId = 1L;
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(DataNotFoundException.class, () -> accountService.getAccountById(accountId));
    }

    @Test
    void testCreateAccount() {
        // Arrange
        Account account = new Account();

        // Act
        Account result = accountService.createAccount(account);

        // Assert
        verify(accountRepository).save(account);
        assertThat(result).isEqualTo(account);
    }

    @Test
    void testUpdateAccount() {
        // Arrange
        Long accountId = 1L;
        Account existingAccount = new Account();
        existingAccount.setId(accountId);

        Account update = new Account();
        update.setName("Updated Name");

        when(accountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));

        // Act
        accountService.updateAccount(accountId, update);

        // Assert
        verify(accountRepository).save(existingAccount);
        assertThat(existingAccount.getName()).isEqualTo(update.getName());
    }

    @Test
    void testUpdateAccountNotFound() {
        // Arrange
        Long accountId = 1L;
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(DataNotFoundException.class, () -> accountService.updateAccount(accountId, new Account()));
    }
}
