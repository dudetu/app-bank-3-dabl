package com.example.appbank2.exception;

/**
 * Исключение, выбрасываемое при недостаточном балансе.
 */
public class LowBalanceException extends RuntimeException {

    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message Сообщение об ошибке.
     */
    public LowBalanceException(String message) {
        super(message);
    }
}

