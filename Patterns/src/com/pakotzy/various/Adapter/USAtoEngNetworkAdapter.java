package com.pakotzy.various.Adapter;

public class USAtoEngNetworkAdapter implements EnglandNetworkConnector {
	private USANetworkConnector usaConnector;

	public USAtoEngNetworkAdapter(USANetworkConnector usaConnector) {
		this.usaConnector = usaConnector;
	}

	@Override
	public String twoFlatConnectors() {
		return usaConnector.twoFlatConnectors();
	}

	@Override
	public String oneFlatCircuitProtector() {
		return "One Flat Circuit Protector";
	}
}
