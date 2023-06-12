package com.lcwr.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GreetingImplTest {
	
	private Greeting greeting;
	@BeforeEach
	public void Setup() {
		System.out.println("Setup");
		greeting = new GreetingImpl();
		
	}
	
	@Test
	public void greetShouldReturnAValidOutput() {
		System.out.println("greetShouldReturnAValidOutput");
		String result = greeting.greet("Junit");
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello Junit", result);
	}
	
	@Test
	public void greetShouldThrowAnException_For_NameIsNull() {
		System.out.println("greetShouldThrowAnException_For_NameIsNull");
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			greeting.greet(null);
		} );
		
	}
	@Test
	public void greetShouldThrowAnException_For_NameIsBlank() {
		System.out.println("greetShouldThrowAnException_For_NameIsBlank");
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			greeting.greet(null);
		} );
	}
	
	@AfterEach
	public void teardown() {
		System.out.println("teardown");
		greeting = null;
	}
}
