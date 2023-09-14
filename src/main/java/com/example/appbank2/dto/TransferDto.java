package com.example.appbank2.dto;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Класс представляет собой объект для передачи данных о переводе между счетами.
 */
@Transactional
public class TransferDto {

    /** Номер счета отправителя. */
    private String fromAccountNumber;

    /** Номер счета получателя. */
    private String toAccountNumber;

    /** Сумма перевода. */
    private BigDecimal amount;
}

