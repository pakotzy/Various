package com.pakotzy.various.Strategy;

public class King extends Character {
	public King() {
		setWeaponBehavior(new SwordBehavior());
	}
}
