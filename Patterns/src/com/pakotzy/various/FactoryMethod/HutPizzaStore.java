package com.pakotzy.various.FactoryMethod;

import com.pakotzy.various.Decorator.*;

public class HutPizzaStore extends PizzaStore {
	@Override
	protected Pizza create(String... pizzaTypes) {
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
