package com.vogella.mockito.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockitoSpyTest {

	@Spy
	List<String> spy = new LinkedList<>();

	@BeforeEach
	void setup() {
		// Alternative way of creating a spy
		// List<String> list = new LinkedList<>();
		// List<String> spy = spy(list);
	}

	@Test
	void testLinkedListSpyCorrect() {

		// when(spy.get(0)).thenReturn("foo");
		// would not work as the delegate it called so spy.get(0)
		// throws IndexOutOfBoundsException (list is still empty)

		// you have to use doReturn() for stubbing
		doReturn("foo").when(spy).get(0);

		assertEquals("foo", spy.get(0));
	}

}
