package com.pakotzy.various.Creational.FactoryMethod;

import com.pakotzy.various.Structural.Decorator.*;

public class HutPizzaStore extends PizzaStore {
	@Override
	public Pizza create(String... pizzaTypes) {
		Pizza pizza = new PizzaHut(Size.MEDIUM);

		for (String pizzaType : pizzaTypes) {
			switch (pizzaType) {
				case "cheese":
					pizza = new Cheese(pizza);
					break;
			}
		}

		return pizza;
	}
}
