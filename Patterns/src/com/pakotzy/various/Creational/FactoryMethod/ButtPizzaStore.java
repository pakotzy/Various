package com.pakotzy.various.Creational.FactoryMethod;

import com.pakotzy.various.Structural.Decorator.*;

public class ButtPizzaStore extends PizzaStore {
	@Override
	public Pizza create(String... pizzaTypes) {
		Pizza pizza = new PizzaButt(Size.LARGE);

		for (String pizzaType : pizzaTypes) {
			switch (pizzaType) {
				case "cheese":
					pizza = new Cheese(pizza);
					break;
				case "gold":
					pizza = new GoldenSnow(pizza);
					break;
			}
		}

		return pizza;
	}
}
