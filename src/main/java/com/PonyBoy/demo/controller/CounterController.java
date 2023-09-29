package com.PonyBoy.demo.controller;

import com.PonyBoy.demo.charactersCounter.CharactersCounterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/count/")
public class CounterController {

    CharactersCounterClass charactersCounterClass;

    @Autowired
    public CounterController(CharactersCounterClass charactersCounterClass){
        this.charactersCounterClass = charactersCounterClass;
    }

    @PostMapping("numOfSymbols")
    public ResponseEntity<String> countNumberOfSymbols(@RequestParam String string){
        HashMap<Character, Integer> responseCounter = new HashMap<>();
        try {
            responseCounter = charactersCounterClass.countCharacters(string);
        }catch (Exception e){
            e.getMessage();
        }
        for (Character name: responseCounter.keySet()) {
            String key = name.toString();
            String value = responseCounter.get(name).toString();
            System.out.println("\""+ key + "\"" + " - " + value);
        }
        System.out.println("-----------------");
        return new ResponseEntity<>(responseCounter.toString(),HttpStatus.OK);
    }

}
