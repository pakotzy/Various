package com.pakotzy.various.FactoryMethod;

import com.pakotzy.various.Decorator.Pizza;

import java.util.Arrays;

public abstract class PizzaStore {
	public Pizza order(String... pizzaTypes) {
		System.out.println("Requested " + Arrays.asList(pizzaTypes));
		return create(pizzaTypes);
	}

	abstract Pizza create(String... pizzaTypes);
}
