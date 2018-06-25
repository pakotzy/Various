package com.pakotzy.various.Creational.AbstractFactory;

public class LuxuriousPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public void createCheese() {
		System.out.println("Creating Lux Cheese");
	}

	@Override
	public void createGold() {
		System.out.println("Create Lux Gold");
	}
}
