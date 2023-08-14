package com.example.appbank2.service;

import com.example.appbank2.entity.Account;
import com.example.appbank2.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Long id);
    Transaction createTransaction(Transaction transaction);

    void executeTransfer(Transaction transaction);
}
