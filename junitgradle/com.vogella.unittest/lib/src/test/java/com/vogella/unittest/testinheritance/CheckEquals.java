package com.vogella.unittest.testinheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

interface CheckEquals {
	@Test
	default void checkEqualsForSameObject() {
		Object o = createInstance();
		assertEquals(o, o);
	}

	Object createInstance();
}
