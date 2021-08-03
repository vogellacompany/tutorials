package com.vogella.unittest.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class HamcrestStringMatcherExampleTest {

	@Test
	void ensureThatAnEmptryStringIsEmpty() {
		String input = "";
		assertThat(input, is(emptyString()));
	}

	@Test
	void ensureThatAStringIsEitherNullOrEmpty() {
		String input = "";
		assertThat(input, is(emptyOrNullString()));
	}

}