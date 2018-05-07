package com.pakotzy.various.AbstractFactory;

import com.pakotzy.various.Decorator.*;
import com.pakotzy.various.FactoryMethod.PizzaStore;

public class LuxuriousPizzaStore extends PizzaStore {
	private LuxuriousPizzaIngredientFactory ingredientFactory = new LuxuriousPizzaIngredientFactory();

	@Override
	public Pizza create(String... pizzaTypes) {
		Pizza pizza = new PizzaButt(Size.LARGE);

		for (String pizzaType : pizzaTypes) {
			switch (pizzaType) {
				case "cheese":
					ingredientFactory.createCheese();
					pizza = new Cheese(pizza);
					break;
				case "gold":
					ingredientFactory.createGold();
					pizza = new GoldenSnow(pizza);
					break;
			}
		}

		return pizza;
	}
}
