package com.pakotzy.various.Creational.FactoryMethod;

import com.pakotzy.various.Structural.Decorator.Pizza;

import java.util.Arrays;

public abstract class PizzaStore {
	public Pizza order(String... pizzaTypes) {
		System.out.println("Requested " + Arrays.asList(pizzaTypes));
		return create(pizzaTypes);
	}

	public abstract Pizza create(String... pizzaTypes);
}
