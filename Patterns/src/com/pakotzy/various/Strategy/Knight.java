package com.pakotzy.various.Strategy;

public class Knight extends Character {
	public Knight() {
		setWeaponBehavior(new AxeBehavior());
	}
}
