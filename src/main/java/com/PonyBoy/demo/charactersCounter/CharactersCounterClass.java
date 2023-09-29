package com.PonyBoy.demo.charactersCounter;

import com.PonyBoy.demo.util.CharactersLimitException;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CharactersCounterClass {
    //Метод для составления списка символов и кол-ва их повторений
    public HashMap<Character,Integer> countCharacters(String string){
        if (string.length() > 20){
            throw new CharactersLimitException();
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < string.length() ; i++){
            if(!map.containsKey(string.charAt(i))){
                map.put(string.charAt(i),1);
            }else{
                Integer counter = map.get(string.charAt(i));
                counter++;
                map.put(string.charAt(i),counter);
            }
        }
        return sortList(map);
    }

    //Метод для сортировки списка символов и кол-ва их повторений
    public HashMap<Character,Integer> sortList(HashMap<Character,Integer> list){
        HashMap<Character,Integer> sortedList = list.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1, LinkedHashMap::new));
        return sortedList;
    }
}
