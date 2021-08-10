
package com.vogella.gwt.helloworld.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloGwt implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Label label = new Label("Hello GWT !!!");
		Button button = new Button("Say something");
		button.addClickHandler(event -> Window.alert("Hello, again"));

		RootPanel.get().add(label);
		RootPanel.get().add(button);
	}
}
