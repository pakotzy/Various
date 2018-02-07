package com.pakotzy.springbootjavafxlove;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import de.felixroske.jfxsupport.SplashScreen;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJavaFxLoveApplication extends AbstractJavaFxApplicationSupport {

	public static void main(String[] args) {
		launchApp(SpringBootJavaFxLoveApplication.class, MainView.class, new SplashView(), args);
	}
}
