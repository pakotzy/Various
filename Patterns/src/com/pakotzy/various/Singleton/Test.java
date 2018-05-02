package com.pakotzy.various.Singleton;

public class Test {
	public static void main(String[] args) {
		System.out.println(EnumSingleton.INSTANCE);
		System.out.println(FactorySingleton.getInstance());
	}
}
