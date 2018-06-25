package com.pakotzy.various.Behavioral.Strategy;

public class BowAndArrowBehavior implements WeaponBehavior {
	@Override
	public String useWeapon() {
		return "Shooting an arrow with a bow";
	}
}
