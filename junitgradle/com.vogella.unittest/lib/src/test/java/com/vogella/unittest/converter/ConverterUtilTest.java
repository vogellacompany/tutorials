package com.vogella.unittest.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class ConverterUtilTest {

	int[][] celsiusFahrenheitMapping = new int[][] { { 10, 50 }, { 40, 104 }, { 0, 32 } };

	@TestFactory
	Stream<DynamicTest> ensureThatCelsiumConvertsToFahrenheit() {
		return Arrays.stream(celsiusFahrenheitMapping).map(entry -> {
			int celsius = entry[0];
			int fahrenheit = entry[1];
			return dynamicTest(celsius + " Celsius are " + fahrenheit + " Fahrenheit", () -> {
				assertEquals(fahrenheit, ConverterUtil.convertCelsiusToFahrenheit(celsius));
			});
		});
	}

	@TestFactory
	Stream<DynamicTest> ensureThatFahrenheitToCelsius() {
		return Arrays.stream(celsiusFahrenheitMapping).map(entry -> {
			int celsius = entry[0];
			int fahrenheit = entry[1];
			return dynamicTest(fahrenheit + " Fahrenheit are " + celsius + " Celsius", () -> {
				assertEquals(celsius, ConverterUtil.convertFahrenheitToCelsius(fahrenheit));
			});
		});
	}

	// TODO Write a similar test fahrenheit to celsius

}