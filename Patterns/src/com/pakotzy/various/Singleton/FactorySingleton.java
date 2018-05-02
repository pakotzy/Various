package com.pakotzy.various.Singleton;

/**
 * Can't be Serialized without additional code, private instance can be changed with reflection
 */
public class FactorySingleton {
	private static final FactorySingleton INSTANCE = new FactorySingleton();

	private String dbDriver = "Super fast flawed DB driver";

	private FactorySingleton(){}

	public static FactorySingleton getInstance() {
		return INSTANCE;
	}

	@Override
	public String toString() {
		return "FactorySingleton{" +
				"dbDriver='" + dbDriver + '\'' +
				'}';
	}
}
