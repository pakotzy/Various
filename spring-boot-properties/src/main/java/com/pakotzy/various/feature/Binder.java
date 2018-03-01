package com.pakotzy.various.feature;

public class Binder extends Feature {
	@Override
	public void initialize() {

	}

	@Override
	public void run() {
		System.out.println("Binder - run()");
	}

	@Override
	public void stop() {

	}

	@Override
	public String toString() {
		return "Binder {\n" +
				getEvents()
				+ "\n}";
	}
}
