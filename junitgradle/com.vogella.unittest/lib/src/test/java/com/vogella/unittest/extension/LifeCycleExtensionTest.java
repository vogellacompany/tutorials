package com.vogella.unittest.extension;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ExtensionVogellaLifeCycle.class)
class LifeCycleExtensionTest {

	@Test
	void test1() {
		assertTrue(true);
	}

	@Test
	void test2() {
		assertTrue(true);
	}

	@Test
	void test3() {
		assertTrue(true);
	}

}