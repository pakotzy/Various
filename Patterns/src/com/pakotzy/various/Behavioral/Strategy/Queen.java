package com.pakotzy.various.Behavioral.Strategy;

public class Queen extends Character {
	public Queen() {
		setWeaponBehavior(new KnifeBehavior());
	}
}
