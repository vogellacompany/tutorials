package com.vogella.unittest.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HamcrestListMatcherExampleTest {

	private List<Integer> list;

	@BeforeEach
	public void setup() {
		list = Arrays.asList(5, 2, 4);

	}

	@Test
	@DisplayName("List should have an intial size of 3")
	void ensureInitialSize() {
		assertThat(list, hasSize(3));
	}

	@Test
	@DisplayName("Check content of the array")
	void containsNumbersInAnyOrder() {
		assertThat(list, containsInAnyOrder(2, 4, 5));
	}

	@Test
	void everyItemGreaterThan1() {
		assertThat(list, everyItem(greaterThan(1)));
	}

}