package com.example.appbank2.controller;
import com.example.appbank2.entity.Account;
import com.example.appbank2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления счетами.
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    /**
     * Конструктор контроллера.
     *
     * @param accountService Сервис управления счетами.
     */
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Получает список всех счетов.
     *
     * @return ResponseEntity со списком счетов и статусом HTTP.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    /**
     * Получает счет по его идентификатору.
     *
     * @param id Идентификатор счета.
     * @return ResponseEntity с счетом и статусом HTTP.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Создает новый счет.
     *
     * @param account Новый счет.
     * @return ResponseEntity с созданным счетом и статусом HTTP.
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
}

