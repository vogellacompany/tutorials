package com.vogella.unittest.sortmethods;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderAnnotationDemoTest {

	@Test
	@Order(1)
	void firstOne() {
		// test something here
	}

	@Test
	@Order(2)
	void secondOne() {
		// test something here
	}

}