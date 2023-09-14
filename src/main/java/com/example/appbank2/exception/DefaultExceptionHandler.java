package com.example.appbank2.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Глобальный обработчик исключений для контроллеров.
 */
@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    /**
     * Обрабатывает исключение DataNotFoundException.
     *
     * @param exception Исключение DataNotFoundException.
     * @return Ответ с HTTP-статусом "Not Found".
     */
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<String> handleDataNotFoundException(Exception exception) {
        log.info("Controller exception: ", exception);
        return ResponseEntity.notFound().build();
    }
}

