package com.vogella.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vogella.mockito.withprivate.MyClassWithPrivateFieldAndMethod;

@ExtendWith(MockitoExtension.class)
class MyClassWithPrivateFieldAndMethodTest {

	@Spy
	MyClassWithPrivateFieldAndMethod mock = new MyClassWithPrivateFieldAndMethod();

	@Test
	void ensureSpyAndReflectiveAccessCanChangeAPrivateField() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		assertEquals("initial", mock.getValue());

		mock.field1 = "Hello";

		when(mock.toBeMockedByMockito()).thenReturn("mocked by Mockito");
		Field declaredField = MyClassWithPrivateFieldAndMethod.class.getDeclaredField("hiddenField");
		Method method = MyClassWithPrivateFieldAndMethod.class.getDeclaredMethod("meineMethod");
		declaredField.setAccessible(true);
		method.setAccessible(true);

		declaredField.set(mock, "changed");
		method.invoke(mock);

		assertEquals("Hello", mock.field1);
		assertEquals("changed", mock.getValue());
		assertEquals("mocked by Mockito", mock.toBeMockedByMockito());
		assertEquals("lalal", mock.getValueSetByPrivateMethod());
	}

}
