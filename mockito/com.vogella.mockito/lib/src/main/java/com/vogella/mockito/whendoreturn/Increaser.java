package com.vogella.mockito.whendoreturn;

public class Increaser {
	int number = 0;

	public int increase() {
		number++;
		return 42;
	}
}
