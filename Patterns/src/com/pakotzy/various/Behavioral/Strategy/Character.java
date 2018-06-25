package com.pakotzy.various.Behavioral.Strategy;

public class Character {
	private WeaponBehavior weaponBehavior;

	public Character() {
		weaponBehavior = new BareHandsBehavior();
	}

	public WeaponBehavior getWeaponBehavior() {
		return weaponBehavior;
	}

	public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
		this.weaponBehavior = weaponBehavior;
	}

	public void fight() {
		System.out.println(getClass().getSimpleName() + " - " + weaponBehavior.useWeapon());
	}

	public void die() {
		System.out.println(getClass().getSimpleName() + " - Uggghhhh..... Now, i'm dead.");
	}
}
