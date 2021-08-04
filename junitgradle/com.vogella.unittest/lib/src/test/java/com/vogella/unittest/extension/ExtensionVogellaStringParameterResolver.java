package com.vogella.unittest.extension;

import javax.inject.Named;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class ExtensionVogellaStringParameterResolver implements ParameterResolver {

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) // <.>
			throws ParameterResolutionException {
		return (parameterContext.isAnnotated(Named.class)
				&& parameterContext.getParameter().getType().equals(String.class));
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return "Demo data"; // <.>
	}
}