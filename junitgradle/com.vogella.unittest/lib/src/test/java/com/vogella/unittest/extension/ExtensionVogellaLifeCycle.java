package com.vogella.unittest.extension;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ExtensionVogellaLifeCycle implements BeforeEachCallback, AfterEachCallback {

	private long startTime;

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		startTime = System.currentTimeMillis();
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		System.out.println(context.getDisplayName() + " took " + (System.currentTimeMillis() - startTime) + " ms.");

	}
}