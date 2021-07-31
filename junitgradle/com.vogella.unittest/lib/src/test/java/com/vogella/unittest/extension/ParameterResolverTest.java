package com.vogella.unittest.extension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ExtensionVogellaStringParameterResolver.class)
class ParameterResolverTest {

	@Test
	void ensureThatJUnit5ExtensionWorks(String parameter) {
		assertNotNull(parameter);
		assertEquals("Demo data", parameter);
	}
}