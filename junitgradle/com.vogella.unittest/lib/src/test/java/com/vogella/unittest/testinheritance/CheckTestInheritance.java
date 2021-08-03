package com.vogella.unittest.testinheritance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CheckTestInheritance implements CheckEquals {

	@Override
	public Object createInstance() {
		return "Hello";
	}

	@Test
	void testMore() {
		assertTrue(true);
	}
}
