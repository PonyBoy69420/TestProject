package com.PonyBoy.demo.controller;

import com.PonyBoy.demo.util.CharactersLimitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerClass {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CharactersLimitException.class)
    public ResponseEntity<CharactersLimitException> handlerInvalid(CharactersLimitException e) {
        CharactersLimitException response = new CharactersLimitException();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
