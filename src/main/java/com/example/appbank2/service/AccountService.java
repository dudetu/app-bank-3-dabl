package com.example.appbank2.service;

import com.example.appbank2.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account createAccount(Account account);

    void updateAccount(Long id, Account update);
}

