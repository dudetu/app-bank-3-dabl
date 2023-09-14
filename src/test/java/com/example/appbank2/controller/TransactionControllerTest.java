package com.example.appbank2.controller;

import com.example.appbank2.entity.Transaction;
import com.example.appbank2.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    private TransactionController transactionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionController = new TransactionController(transactionService);
    }

    @Test
    void testGetAllTransactions() {
        List<Transaction> transactions = Arrays.asList(new Transaction(), new Transaction());
        when(transactionService.getAllTransactions()).thenReturn(transactions);

        ResponseEntity<List<Transaction>> response = transactionController.getAllTransactions();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transactions, response.getBody());
    }

    @Test
    void testGetTransactionById() {
        Long transactionId = 1L;
        Transaction transaction = new Transaction();
        when(transactionService.getTransactionById(transactionId)).thenReturn(transaction);

        ResponseEntity<Transaction> response = transactionController.getTransactionById(transactionId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transaction, response.getBody());
    }

    @Test
    void testGetTransactionById_NotFound() {
        Long transactionId = 1L;
        when(transactionService.getTransactionById(transactionId)).thenReturn(null);

        ResponseEntity<Transaction> response = transactionController.getTransactionById(transactionId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateTransaction() {
        Transaction transaction = new Transaction();
        when(transactionService.createTransaction(transaction)).thenReturn(transaction);

        ResponseEntity<Transaction> response = transactionController.createTransaction(transaction);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(transaction, response.getBody());
    }
}
