package com.vogella.unittest.converter;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class ConverterUtilTest {

	int[][] celsiusFahrenheitMapping = new int[][] { { 10, 50 }, { 40, 104 }, { 0, 32 } };

	@TestFactory
	Stream<DynamicTest> ensureThatCelsiumConvertsToFahrenheit() {
		return Arrays.stream(celsiusFahrenheitMapping).map(entry -> {
			// access celcius and fahrenheit from entry
			int celsius = entry[0];
			int fahrenheit = entry[1];
			return null;
			// return a dynamicTest which checks that that the convertion from celcius to
			// fahrenheit is correct
		});

	}

	Stream<DynamicTest> ensureThatFahrenheitToCelsiumConverts() {
		return null;
		// TODO Write a similar test fahrenheit to celsius
	}
}
