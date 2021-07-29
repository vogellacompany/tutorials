package com.vogella.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class UsingParameterizedTest {

	public static int[][] data() {
		return new int[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
	}

	@ParameterizedTest
	@MethodSource(value = "data")
	void testWithStringParameter(int[] data) {
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
}