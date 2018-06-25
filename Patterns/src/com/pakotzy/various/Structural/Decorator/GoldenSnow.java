package com.pakotzy.various.Structural.Decorator;

public class GoldenSnow extends PizzaDecorator {
	private Pizza pizza;

	public GoldenSnow(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDesctiprion() {
		return pizza.getDesctiprion() + ", GoldenSnow";
	}

	@Override
	public double cost() {
		return pizza.cost() + 99 * pizza.getSize().getMultiplier();
	}
}
