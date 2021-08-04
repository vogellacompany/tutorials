package com.vogella.mockito;

public class MyClassWithField {

	public String field1 = "";
	private String hiddenField = "initial";

	public String getValue() {
		return hiddenField;
	}

	public String toBeMockedByMockito() {
		return "stuff";
	}
}