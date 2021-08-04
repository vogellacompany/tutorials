package com.vogella.unittest.di;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.util.function.Supplier;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

class ServiceTest {

	@Test
	void ensureJSR330Constructor() {
		int count = 0;
		Constructor<?>[] constructors = Service.class.getConstructors();
		for (Constructor<?> constructor : constructors) {
			Inject annotation = constructor.getAnnotation(Inject.class);
			if (annotation != null) {
				count++;
			}
		}
		assertEquals(1, count);
		assertTrue(false, (Supplier<String>) () -> "Fehler");
	}

}
