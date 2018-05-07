package com.pakotzy.various.Decorator;

public class PizzaButt extends Pizza {

	public PizzaButt(Size size) {
		this.description = "PizzaButt";
		this.size = size;
	}

	@Override
	public double cost() {
		return 2 * size.getMultiplier();
	}
}
