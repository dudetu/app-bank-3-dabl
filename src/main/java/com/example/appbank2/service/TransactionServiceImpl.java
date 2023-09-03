package com.example.appbank2.service;

import com.example.appbank2.entity.Account;
import com.example.appbank2.entity.Transaction;
import com.example.appbank2.exception.LowBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.appbank2.repository.TransactionRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    /*
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }


     */
    @Override
    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        BigDecimal amount = transaction.getAmount();

        Long senderId = transaction.getSenderId();
        Account sender = accountService.getAccountById(senderId);
        BigDecimal balance = sender.getBalance();

        Long recipientId = transaction.getRecipientId();
        Account recipient = accountService.getAccountById(recipientId);
        BigDecimal recipientBalance = recipient.getBalance();

        if (balance.compareTo(amount) < 0) {
            throw new LowBalanceException("Sender balance is too low");
        }
        sender.setBalance(balance.subtract(amount));
        recipient.setBalance(recipientBalance.add(amount));

        accountService.updateAccount(senderId, sender);
        accountService.updateAccount(recipientId, recipient);

        return transactionRepository.save(transaction);
    }
}

