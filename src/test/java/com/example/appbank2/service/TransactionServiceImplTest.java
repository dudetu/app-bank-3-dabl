package com.example.appbank2.service;
import com.example.appbank2.entity.Account;
import com.example.appbank2.entity.Transaction;
import com.example.appbank2.exception.LowBalanceException;
import com.example.appbank2.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TransactionServiceImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTransactions() {
        // Arrange
        when(transactionRepository.findAll()).thenReturn(List.of(
                new Transaction(), new Transaction()
        ));

        // Act
        List<Transaction> transactions = transactionService.getAllTransactions();

        // Assert
        assertThat(transactions).hasSize(2);
    }

    @Test
    void testGetTransactionById_ExistingTransaction() {
        // Arrange
        Long transactionId = 1L;
        Transaction transaction = new Transaction();
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(transaction));

        // Act
        Transaction result = transactionService.getTransactionById(transactionId);

        // Assert
        assertThat(result).isEqualTo(transaction);
    }

    @Test
    void testGetTransactionById_NonExistingTransaction() {
        // Arrange
        Long transactionId = 1L;
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThat(transactionService.getTransactionById(transactionId)).isNull();
    }

    @Test
    void testCreateTransaction_SufficientBalance() {
        // Arrange
        BigDecimal amount = BigDecimal.valueOf(100);
        Long senderId = 1L;
        Long recipientId = 2L;

        Account sender = new Account();
        sender.setId(senderId);
        sender.setBalance(BigDecimal.valueOf(500));

        Account recipient = new Account();
        recipient.setId(recipientId);
        recipient.setBalance(BigDecimal.valueOf(200));

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setSenderId(senderId);
        transaction.setRecipientId(recipientId);

        when(accountService.getAccountById(senderId)).thenReturn(sender);
        when(accountService.getAccountById(recipientId)).thenReturn(recipient);

        // Act
        transactionService.createTransaction(transaction);

        // Assert
        assertThat(sender.getBalance()).isEqualByComparingTo(BigDecimal.valueOf(400));
        assertThat(recipient.getBalance()).isEqualByComparingTo(BigDecimal.valueOf(300));
        verify(accountService, times(2)).updateAccount(anyLong(), any(Account.class));
        verify(transactionRepository).save(transaction);
    }

    @Test
    void testCreateTransaction_InsufficientBalance() {
        // Arrange
        BigDecimal amount = BigDecimal.valueOf(600);
        Long senderId = 1L;
        Long recipientId = 2L;

        Account sender = new Account();
        sender.setId(senderId);
        sender.setBalance(BigDecimal.valueOf(500));

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setSenderId(senderId);
        transaction.setRecipientId(recipientId);

        when(accountService.getAccountById(senderId)).thenReturn(sender);

        // Act & Assert
        assertThrows(LowBalanceException.class, () -> transactionService.createTransaction(transaction));
        assertThat(sender.getBalance()).isEqualByComparingTo(BigDecimal.valueOf(500));
        verify(accountService, never()).updateAccount(anyLong(), any(Account.class));
        verify(transactionRepository, never()).save(transaction);
    }
}

