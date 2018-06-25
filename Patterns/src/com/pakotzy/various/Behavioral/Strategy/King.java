package com.pakotzy.various.Behavioral.Strategy;

public class King extends Character {
	public King() {
		setWeaponBehavior(new SwordBehavior());
	}
}
