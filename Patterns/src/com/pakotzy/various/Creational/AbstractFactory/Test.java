package com.pakotzy.various.Creational.AbstractFactory;

import com.pakotzy.various.Creational.FactoryMethod.PizzaStore;

import static com.pakotzy.various.Creational.FactoryMethod.Test.printPizza;

public class Test {
	public static void main(String[] args) {
		PizzaStore buttPizza = new LuxuriousPizzaStore();
		printPizza(buttPizza.order("cheese", "gold"));
	}
}
