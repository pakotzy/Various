package com.pakotzy.various.Behavioral.Strategy;

public class Knight extends Character {
	public Knight() {
		setWeaponBehavior(new AxeBehavior());
	}
}
