package com.vogella.unittest.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AssertJExamplesTests {

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
			assertThat(list).hasSize(3);
		}

		@Test
		@DisplayName("Check content of the array")
		void containsNumbersInAnyOrder() {
			assertThat(list).allMatch(number -> {
				if (number instanceof Integer) {
					return true;
				} else {
					return false;
				}
			});

		}

		@Test
		void everyItemGreaterThan1() {
			assertThat(list).allMatch(number -> number > 1);
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
			assertThat(ints).hasSize(4);
		}

		@Test
		void arrayContainsNumbersInGivenOrder() {
			assertThat(ints).allMatch(number -> {
				if (number instanceof Integer) {
					return true;
				} else {
					return false;
				}
			});
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

		// tests for the Task
		@Test
		void objectHasSummaryProperty() {
			Task task = new Task(1, "Learn Hamcrest", "Important");
			assertThat(task).hasFieldOrProperty("summary");
		}

		@Test
		void objectHasCorrectSummaryValue() {
			Task task = new Task(1, "Learn Hamcrest", "Important");
			assertThat(task).hasFieldOrPropertyWithValue("summary", "Learn Hamcrest");
		}

		@Test
		void objectHasSameProperties() {
			Task todo1 = new Task(1, "Learn Hamcrest", "Important");
			Task todo2 = new Task(1, "Learn Hamcrest", "Important");
			// shortest
			assertThat(todo1).usingRecursiveComparison().isEqualTo(todo2);

			// manual
			assertThat(todo1).extracting("summary", "description", "id").containsExactly(todo2.getSummary(),
					todo2.getDescription(), todo2.getId());
			
			
			// old way
			assertThat(todo1).isEqualToComparingOnlyGivenFields(todo2, "summary", "description");

		}
	}

	@DisplayName("Tests for String")
	@Nested
	class StringTests {
		// tests for string
		@Test
		void ensureThatAnEmptryStringIsEmpty() {
			String input = "";
			assertThat(input).isEmpty();
		}

		@Test
		void ensureThatAStringIsEitherNullOrEmpty() {
			String input = "";
			assertThat(input).isNullOrEmpty();
		}
	}
}