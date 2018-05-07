package com.pakotzy.various.Decorator;

public class PizzaHut extends Pizza {

	public PizzaHut(Size size) {
		this.description = "PizzaHut";
		this.size = size;
	}

	@Override
	public double cost() {
		return 1 * size.getMultiplier();
	}
}
