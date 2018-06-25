package com.pakotzy.various.Creational.FactoryMethod;

import com.pakotzy.various.Structural.Decorator.Pizza;

public class Test {
	public static void main(String[] args) {
		PizzaStore hutPizza = new HutPizzaStore();
		printPizza(hutPizza.order("cheese"));

		PizzaStore buttPizza = new ButtPizzaStore();
		printPizza(buttPizza.order("cheese", "gold"));
	}

	public static void printPizza(Pizza pizza) {
		System.out.println(pizza.getDesctiprion());
	}
}
