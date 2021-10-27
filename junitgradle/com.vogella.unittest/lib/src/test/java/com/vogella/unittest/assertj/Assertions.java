package com.vogella.unittest.assertj;

public class Assertions {

	public static UserAssert assertThat(User actual) {
		return new UserAssert(actual);
	}
}