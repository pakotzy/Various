package com.pakotzy.various.Singleton;

/**
 * Can be Serialized and can't be changed with reflection
 * Instance field will not be Serialized :(
 */
public enum EnumSingleton {
	INSTANCE;

	private String dbDriver = "Fastest DB driver on the Earth";

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	@Override
	public String toString() {
		return "EnumSingleton{" +
				"dbDriver='" + dbDriver + '\'' +
				'}';
	}
}
