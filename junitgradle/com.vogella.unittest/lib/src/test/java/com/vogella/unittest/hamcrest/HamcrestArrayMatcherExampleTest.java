package com.vogella.unittest.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HamcrestArrayMatcherExampleTest {

	private Integer[] ints;

	@BeforeEach
	void setup() {
		ints = new Integer[] { 7, 5, 12, 16 };
	}

	@Test
	void arrayHasSizeOf4() {
		assertThat(ints, arrayWithSize(4));
	}

	@Test
	void arrayContainsNumbersInGivenOrder() {
		assertThat(ints, arrayContaining(7, 5, 12, 16));
	}

}