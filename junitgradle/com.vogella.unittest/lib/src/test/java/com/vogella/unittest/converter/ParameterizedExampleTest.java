package com.vogella.unittest.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ParameterizedExampleTest {

	public static int[][] data() {
		return new int[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
	}

	@ParameterizedTest(name = "{index} called with: {0}")
	@MethodSource(value = "data")
	void testWithStringParameter(int[] data) {
		Arguments.of("An important file", "Test");

		MyClass tester = new MyClass();
		int m1 = data[0];
		int m2 = data[1];
		int expected = data[2];

		assertEquals(expected, tester.multiply(m1, m2));
	}

	// class to be tested
	class MyClass {
		public int multiply(int i, int j) {
			return i * j;
		}
	}

	@ParameterizedTest(name = "{0} * {1} = {2}")
	@CsvSource({ "0,    1,   0", "1,    2,   2", "49,  50, 2450", "1,  100, 100" })
	void add(int first, int second, int expectedResult) {
		MyClass calculator = new MyClass();
		assertEquals(expectedResult, calculator.multiply(first, second),
				() -> first + " * " + second + " should equal " + expectedResult);
	}
}