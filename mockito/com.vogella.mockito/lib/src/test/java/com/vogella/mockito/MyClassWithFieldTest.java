package com.vogella.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MyClassWithFieldTest {

	@Spy
	MyClassWithField mock;

	@Test
	void ensureSpyAndReflectiveAccessCanChangeAPrivateField()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		assertEquals("initial", mock.getValue());

		mock.field1 = "Hello";

		when(mock.toBeMockedByMockito()).thenReturn("mocked by Mockito");
		Field declaredField = MyClassWithField.class.getDeclaredField("hiddenField");
		declaredField.setAccessible(true);
		declaredField.set(mock, "changed");

		assertEquals("Hello", mock.field1);
		assertEquals("changed", mock.getValue());
		assertEquals("mocked by Mockito", mock.toBeMockedByMockito());
	}

}
