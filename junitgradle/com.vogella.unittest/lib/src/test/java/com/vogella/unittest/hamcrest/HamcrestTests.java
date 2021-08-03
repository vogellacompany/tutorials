package com.vogella.unittest.hamcrest;

import static com.vogella.unittest.model.Race.HOBBIT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.vogella.unittest.model.Race;
import com.vogella.unittest.model.TolkienCharacter;
import com.vogella.unittest.services.DataService;

class HamcrestTests {

	@Test
	void firstHamcrestMatcherForLists() {
		List<Integer> list = Arrays.asList(5, 2, 4);
		// test has list has size of 3
		// contains the elements 2, 4, 5 a any order
		// That every item is greater than 1
		assertThat(list, hasSize(3));
		assertThat(list, containsInAnyOrder(2, 4, 5));
		assertThat(list, everyItem(greaterThan(1)));
	}

	@Test
	void tolkienCharacterShouldHaveProperties() {
		TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
		// ensure that TolkienCharacter has the bean property "name"
		// ensure that TolkienCharacter has the bean property "age"

		// Hint: maybe you need to change your data model

		assertThat(frodo, hasProperty("name"));
		assertThat(frodo, hasProperty("age", is(greaterThan(-1))));
	}

	@Test
	void validateTolkeinCharactorsInitializationWorks() {
		TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
		// age is 33
		// name is "Frodo"
		// name is not "Frodon"
		assertThat(frodo.age, is(33));
		assertThat(frodo.getName(), is("Frodo"));
		assertThat(frodo.getName(), is(not("Frodon")));

	}

	@Test
	void ensureThatFellowsAreNotOrcs() {
		List<TolkienCharacter> fellowship = new DataService().getFellowship();
		assertThat(fellowship, everyItem(hasProperty("race", is(not(Race.ORC)))));
	}
}