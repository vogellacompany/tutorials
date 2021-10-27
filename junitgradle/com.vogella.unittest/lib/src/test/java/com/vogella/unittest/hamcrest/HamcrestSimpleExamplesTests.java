package com.vogella.unittest.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class HamcrestSimpleExamplesTests {


	// tests for the list
	@DisplayName("Tests for the List")
	@Nested
	class ListTests {
		
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

	@DisplayName("Tests for the array")
	@Nested
	class ArrayTests {
		private Integer[] ints;

		@BeforeEach
		public void setup() {
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

	@DisplayName("Tests for the Task")
	@Nested
	class TaskTests {
		
		// class to be tested
		public class Task {

			public String getSummary() {
				return summary;
			}

			public void setSummary(String summary) {
				this.summary = summary;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public int getYear() {
				return year;
			}

			public void setYear(int year) {
				this.year = year;
			}

			public long getId() {
				return id;
			}

			private final long id;
			private String summary;
			private String description;
			private int year;

			public Task(long id, String summary, String description) {
				this.id = id;
				this.summary = summary;
				this.description = description;
			}

			// getters/setters
		}

		//more
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

	@DisplayName("Tests for String")
	@Nested
	class StringTests {
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
}
