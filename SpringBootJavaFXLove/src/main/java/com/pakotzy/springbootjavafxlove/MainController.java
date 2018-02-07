package com.pakotzy.springbootjavafxlove;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class MainController {
	@FXML
	private Label helloLabel;

	@FXML
	private TextField nameField;

	@Autowired
	private ActionService actionService;

	@FXML
	private void setHelloText(final Event event) {
		final String textToShow = actionService.processName(nameField.getText());
		helloLabel.setText(textToShow);
	}
}
