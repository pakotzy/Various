package com.pakotzy.various.AbstractFactory;

import com.pakotzy.various.FactoryMethod.PizzaStore;

import static com.pakotzy.various.FactoryMethod.Test.printPizza;

public class Test {
	public static void main(String[] args) {
		PizzaStore buttPizza = new LuxuriousPizzaStore();
		printPizza(buttPizza.order("cheese", "gold"));
	}
}
