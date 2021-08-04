package com.vogella.unittest.di;

import javax.inject.Inject;

public class Service {

	@Inject
	String s;

	@Inject
	public Service() {
	}

	// Schreibe einen Test der ueberprüft das nur eine Constructor mit @Inject
	// annotiert ist

	public Service(String s) {
		this.s = s;
	}
}
