package com.pakotzy.various.Strategy;

public class Troll extends Character {
	public Troll() {
		setWeaponBehavior(new BowAndArrowBehavior());
	}
}
