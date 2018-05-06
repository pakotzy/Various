package com.pakotzy.various.Decorator;

public enum Size {
	SMALL(0.5), MEDIUM(1), LARGE(1.5);

	private double multiplier;

	Size(double multiplier) {
		this.multiplier = multiplier;
	}

	public double getMultiplier() {
		return multiplier;
	}
}
