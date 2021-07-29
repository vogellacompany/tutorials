package com.vogella.unittest.services;

import static com.vogella.unittest.model.Race.HOBBIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.vogella.unittest.model.TolkienCharacter;

class DataModelAssertThrowsTest {

	@Test
	@DisplayName("Ensure that access to the fellowship throws exception outside the valid range")
	void ensureThatIndexOutOfBoundMessageForFellowAccessIsCorrect() {
		DataService dataService = new DataService();
		List<TolkienCharacter> fellowship = dataService.getFellowship();
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> fellowship.get(20));
		assertEquals("Index 20 out of bounds for length 9", exception.getMessage());
	}

	@Test
	void ensureThatAgeMustBeLargerThanZeroViaSetter() {
		// Age is not allowed to be smaller than zero
		TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
		assertThrows(IllegalArgumentException.class, () -> frodo.setAge(-1));

	}

	@Test
	void ensureThatAgeMustBeLargerThanZeroViaConstructor() {
		// Age is not allowed to be smaller than zero

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> new TolkienCharacter("Frodo", -1, HOBBIT));
		assertEquals("Age is not allowed to be smaller than zero", exception.getMessage());
	}

}