package com.pakotzy.various.Structural.Adapter;

public class EnglandNetworkStation {
	public void connect(EnglandNetworkConnector connector) {
		System.out.println("Putting in - " + connector.twoFlatConnectors() + " and " + connector.oneFlatCircuitProtector());
	}
}
