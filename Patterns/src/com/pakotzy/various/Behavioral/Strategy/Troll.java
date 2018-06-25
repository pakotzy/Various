package com.pakotzy.various.Behavioral.Strategy;

public class Troll extends Character {
	public Troll() {
		setWeaponBehavior(new BowAndArrowBehavior());
	}
}
