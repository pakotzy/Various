package com.pakotzy.various.Behavioral.Strategy;

public class Test {
	public static void main(String[] args) {
		Character queen = new Queen();
		Character troll = new Troll();

		queen.fight();
		troll.fight();
		queen.setWeaponBehavior(new AxeBehavior());
		queen.fight();
		troll.die();
	}
}
