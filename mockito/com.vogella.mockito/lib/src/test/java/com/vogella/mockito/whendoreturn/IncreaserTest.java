package com.vogella.mockito.whendoreturn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IncreaserTest {

	@Spy
	Increaser increase = new Increaser();

	@Test
	void whenShouldHaveSideEffects() {
		when(increase.increase()).thenReturn(10);
		int value = increase.increase();
		assertEquals(10, value);
		assertEquals(1, increase.number);
	}

	@Test
	void doReturnShouldNotHaveSideEffects() {
		doReturn(10).when(increase).increase();
		int value = increase.increase();
		assertEquals(10, value);
		assertEquals(0, increase.number);
	}

}
