package com.vogella.unittest.di;

import javax.inject.Inject;

public class Service {

	@Inject
	String s;

	@Inject
	public Service() {
	}

	public Service(String s) {
		this.s = s;
	}
}
