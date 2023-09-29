package com.PonyBoy.demo;

import com.PonyBoy.demo.charactersCounter.CharactersCounterClass;
import com.PonyBoy.demo.util.CharactersLimitException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	CharactersCounterClass charactersCounterClass;



	@Test
	void test1() {
		String string = "aaaaabcccc";
		String result = charactersCounterClass.countCharacters(string).toString();
		assertEquals(result,"{a=5, c=4, b=1}");
	}

	@Test
	void test2() {
		String string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Throwable exception = assertThrows(CharactersLimitException.class, () -> charactersCounterClass.countCharacters(string));
		assertEquals("ОШИБКА: Размер строки превышает 20 символов, пожалуйста, введите строку покороче", exception.getMessage());
	}

	@Test
	void test3() {
		String string = "Корабли лавировали";
		String result = charactersCounterClass.countCharacters(string).toString();
		assertEquals(result,"{а=3, и=3, л=3, р=2, в=2, о=2,  =1, б=1, К=1}");
	}

}
