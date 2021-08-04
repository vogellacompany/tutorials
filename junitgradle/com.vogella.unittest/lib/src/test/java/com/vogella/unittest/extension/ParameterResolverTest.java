package com.vogella.unittest.extension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Named;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ExtensionVogellaStringParameterResolver.class)
class ParameterResolverTest {

	@Test
	void ensureThatJUnit5ExtensionWorks(@Named("super") String parameter) {
		assertNotNull(parameter);
		assertEquals("super", parameter);
	}

	@Test
	void ensureThatJUnit5ExtensionWorks2(@Named String parameter) {
		assertNotNull(parameter);
		assertEquals("Not available", parameter);
	}

}