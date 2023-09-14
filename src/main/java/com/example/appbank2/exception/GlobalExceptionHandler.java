package com.example.appbank2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Глобальный обработчик исключений для контроллеров.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обрабатывает исключение LowBalanceException.
     *
     * @param ex Исключение LowBalanceException.
     * @return Ответ с HTTP-статусом "Bad Request" и сообщением об ошибке.
     */
    @ExceptionHandler(LowBalanceException.class)
    public ResponseEntity<String> handleLowBalanceException(LowBalanceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
