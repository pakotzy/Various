package com.pakotzy.various.Behavioral.Strategy;

public class KnifeBehavior implements WeaponBehavior {
	@Override
	public String useWeapon() {
		return "Cutting with a knife";
	}
}
