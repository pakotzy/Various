package com.pakotzy.various.Strategy;

public class Queen extends Character {
	public Queen() {
		setWeaponBehavior(new KnifeBehavior());
	}
}
