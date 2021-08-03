package com.vogella.unittest.platform;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class LinuxTests {
	@Test
	void testName() throws Exception {
		// only run on Linux
		Assumptions.assumeTrue(System.getProperty("os.name").contains("Linux"));
		assertTrue(true);
	}
}
