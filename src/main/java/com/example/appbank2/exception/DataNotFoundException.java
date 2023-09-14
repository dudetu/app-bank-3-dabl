package com.example.appbank2.exception;

/**
 * Исключение, выбрасываемое при отсутствии данных.
 */
public class DataNotFoundException extends RuntimeException {

    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message Сообщение об ошибке.
     */
    public DataNotFoundException(String message) {
        super(message);
    }
}

