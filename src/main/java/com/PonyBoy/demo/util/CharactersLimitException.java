package com.PonyBoy.demo.util;

public class CharactersLimitException extends RuntimeException {
        public String getMessage(){
            System.out.println("ОШИБКА: Размер строки превышает 20 символов, пожалуйста, введите строку покороче");
            return "ОШИБКА: Размер строки превышает 20 символов, пожалуйста, введите строку покороче";
        }
    }

