package com.vogella.mockito.withprivate;

public class MyClassWithPrivateFieldAndMethod {

	public String field1 = "";
	private String valueSetByPrivateMethod = "";
	private String hiddenField = "initial";

	public String getValue() {
		return hiddenField;
	}

	public String getValueSetByPrivateMethod() {
		return valueSetByPrivateMethod;
	}

	public String toBeMockedByMockito() {
		return "stuff";
	}

	public void hello() {
		meineMethod();
	}

	// 1.) hello im test aufrufen und danach per Reflextion valueSetByPrivateMethod
	// so setzen wie ich will
	// 2.) Test double MyClassToTest extends MyClassWithPrivateFieldAndMethod
	// 3.) Code umschreiben.....
	// @VisibleForTesting

	private void meineMethod() {
		valueSetByPrivateMethod = "lalal";
	}
}