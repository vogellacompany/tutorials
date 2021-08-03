package com.vogella.unittest.sortmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
class SorterDemoTest {

	@Test
	@DisplayName("B sorted")
	void a() {
		// test something here
	}

	@Test
	@DisplayName("A sorted")
	void b() {
		// test something here
	}

}