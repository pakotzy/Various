package com.pakotzy.various.FactoryMethod;

import com.pakotzy.various.Decorator.Pizza;

public class Test {
	public static void main(String[] args) {
		PizzaStore hutPizza = new HutPizzaStore();
		printPizza(hutPizza.order("cheese"));

		PizzaStore buttPizza = new ButtPizzaStore();
		printPizza(buttPizza.order("cheese", "gold"));
	}

	private static void printPizza(Pizza pizza) {
		System.out.println(pizza.getDesctiprion());
	}
}
