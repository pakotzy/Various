package com.pakotzy.various.Structural.Decorator;

public class Cheese extends PizzaDecorator {
	private Pizza pizza;

	public Cheese(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDesctiprion() {
		return pizza.getDesctiprion() + ", Cheese";
	}

	@Override
	public double cost() {
		return pizza.cost() + .20 * pizza.getSize().getMultiplier();
	}
}
