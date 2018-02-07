package com.pakotzy.springbootjavafxlove;

import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.ResourceBundle;

@Component
public class DefaultActionService implements ActionService {
	private ResourceBundle bundle = ResourceBundle.getBundle("com.pakotzy.springbootjavafxlove.main");

	@Override
	public String processName(String name) {
		if (!name.equals("Pasha")) name = "Unknown traveler";
		return MessageFormat.format(bundle.getString("greeting"), name);
	}
}
