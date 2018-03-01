package com.pakotzy.various.feature;

public class Writer extends Feature {
	@Override
	public void initialize() {

	}

	@Override
	public void run() {
		System.out.println("Writer - run()");
	}

	@Override
	public void stop() {

	}

	@Override
	public String toString() {
		return "Writer {\n" +
				getEvents()
				+ "\n}";
	}
}
