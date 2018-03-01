package com.pakotzy.various.feature;

public class Crafter extends Feature {
	@Override
	public void initialize() {

	}

	@Override
	public void run() {
		System.out.println("Crafter - run()");
	}

	@Override
	public void stop() {

	}

	@Override
	public String toString() {
		return "Crafter {\n" +
				getEvents()
				+ "\n}";
	}
}
