package com.example.appbank2.service;

import com.example.appbank2.entity.Account;
import com.example.appbank2.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.appbank2.repository.AccountRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("account not found"));
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public void updateAccount(Long id, Account update) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("account not found"));
        Account updatedAccount = updateFields(update, account);
        accountRepository.save(updatedAccount);
    }

    private Account updateFields(Account update, Account account) {
        if (update.getName() != null) {
            account.setName(update.getName());
        }
        if (update.getType() != null) {
            account.setType(update.getType());
        }
        if (update.getStatus() != null) {
            account.setStatus(update.getStatus());
        }
        if (update.getBalance() != null) {
            account.setBalance(update.getBalance());
        }

        if (update.getCurrencyCode() != null) {
            account.setCurrencyCode(update.getCurrencyCode());
        }
        if (update.getUpdatedAt() != null) {
            account.setUpdatedAt(update.getUpdatedAt());
        }
        //TODO дописать ифы на каждое поле кроме ид и криетед-эт - СДЕЛАНО
        return account;
    }

}

