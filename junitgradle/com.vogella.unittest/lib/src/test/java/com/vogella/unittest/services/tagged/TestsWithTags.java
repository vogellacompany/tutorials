package com.vogella.unittest.services.tagged;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestsWithTags {

	@Test
	@Tag("fast")
	void ensureFastTestsRun() {
		assertTrue(true);
	}

	@Test
	@Tag("slow")
	void ensureSlowTestsRun() {
		assertTrue(true);
	}
}
