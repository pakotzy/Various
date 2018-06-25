package com.pakotzy.various.Structural.Decorator;

public class Test {
	public static void main(String[] args) {
		Pizza pizza1 = new PizzaHut(Size.SMALL);
		System.out.println(pizza1.getDesctiprion() + " - " + pizza1.cost());

		Pizza pizza2 = new PizzaButt(Size.LARGE);
		pizza2 = new Cheese(pizza2);
		pizza2 = new GoldenSnow(pizza2);
		pizza2 = new Cheese(pizza2);
		System.out.println(pizza2.getDesctiprion() + " - " + pizza2.cost());

		Pizza pizza3 = new PizzaHut(Size.SMALL);
		pizza3 = new GoldenSnow(pizza3);
		System.out.println(pizza3.getDesctiprion() + " - " + pizza3.cost());
	}
}
