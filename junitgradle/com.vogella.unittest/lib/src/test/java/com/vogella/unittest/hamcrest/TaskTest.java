package com.vogella.unittest.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void objectHasSummaryProperty() {
		Task task = new Task(1, "Learn Hamcrest", "Important");
		assertThat(task, hasProperty("summary"));
	}

	@Test
	void objectHasCorrectSummaryValue() {
		Task task = new Task(1, "Learn Hamcrest", "Important");
		assertThat(task, hasProperty("summary", equalTo("Learn Hamcrest")));
	}

	@Test
	void objectHasSameProperties() {
		Task todo1 = new Task(1, "Learn Hamcrest", "Important");
		Task todo2 = new Task(1, "Learn Hamcrest", "Important");

		assertThat(todo1, samePropertyValuesAs(todo2));
	}
}