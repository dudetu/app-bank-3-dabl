package com.example.appbank2.controller.exception_handler;

import com.example.appbank2.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<String> handleDataNotFoundException(Exception exception) {
        log.info("Controller exception: ", exception);
        return ResponseEntity.notFound().build();
    }

    //TODO написать хендлер для LowBalanceException

}
