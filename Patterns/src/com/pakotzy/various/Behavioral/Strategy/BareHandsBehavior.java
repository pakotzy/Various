package com.pakotzy.various.Behavioral.Strategy;

public class BareHandsBehavior implements WeaponBehavior {
	@Override
	public String useWeapon() {
		return "Brawling";
	}
}
