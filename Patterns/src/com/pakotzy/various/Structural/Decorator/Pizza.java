package com.pakotzy.various.Structural.Decorator;

public abstract class Pizza {
	public String description = "Abstract Pizza";
	public Size size = Size.MEDIUM;

	public String getDesctiprion() {
		return description;
	}

	public Size getSize() {
		return size;
	}

	public abstract double cost();
}
