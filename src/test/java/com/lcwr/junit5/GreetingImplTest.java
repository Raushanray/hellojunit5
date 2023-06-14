package com.lcwr.junit5;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

//
//@RunWith(JUnitPlatform.class)
//@SpringBootTest
//@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class GreetingImplTest {
	
//	private Greeting greeting;
//	
//	@BeforeEach
//	public void Setup() {
//		System.out.println("Setup");
//		greeting = new GreetingImpl();
//		
//	}
//	
//	@Test
//	public void greetShouldReturnAValidOutput() {
//		System.out.println("greetShouldReturnAValidOutput");
//		String result = greeting.greet("Junit");
//		Assertions.assertNotNull(result);
//		Assertions.assertEquals("Hello Junit", result);
//	}
//	
//	@Test
//	public void greetShouldThrowAnException_For_NameIsNull() {
//		System.out.println("greetShouldThrowAnException_For_NameIsNull");
//		Assertions.assertThrows(IllegalArgumentException.class,()-> {
//			greeting.greet(null);
//		} );
//		
//	}
//	@Test
//	public void greetShouldThrowAnException_For_NameIsBlank() {
//		System.out.println("greetShouldThrowAnException_For_NameIsBlank");
//		Assertions.assertThrows(IllegalArgumentException.class,()-> {
//			greeting.greet(null);
//		} );
//	}
//	
//	@AfterEach
//	public void teardown() {
//		System.out.println("teardown");
//		greeting = null;
//	}
	
	@Mock
	private GreetingService service;
	
	@InjectMocks
	private GreetingImpl greeting;
	
	
	
	@Test
	public void greetShouldReturnAValidOutput() {
		System.out.println("greetShouldReturnAValidOutput");
		when(service.greet("Junit")).thenReturn("Hello Junit");
		String result = greeting.greet("Junit");
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello Junit", result);
	}
	
	@Test
	public void greetShouldThrowAnException_For_NameIsNull() {
		System.out.println("greetShouldThrowAnException_For_NameIsNull");
		doThrow(IllegalArgumentException.class).when(service).greet(null);
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			greeting.greet(null);
		} );

	}
	@Test
	public void greetShouldThrowAnException_For_NameIsBlank() {
		System.out.println("greetShouldThrowAnException_For_NameIsBlank");
		doThrow(IllegalArgumentException.class).when(service).greet("");
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			greeting.greet("");
		} );
	}
	
	
}
