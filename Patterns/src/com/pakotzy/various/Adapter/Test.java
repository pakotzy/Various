package com.pakotzy.various.Adapter;

public class Test {
	public static void main(String[] args) {
		EnglandNetworkStation station = new EnglandNetworkStation();

		USANetworkConnector usaConnector = new JenkoIncUSANetConnector();
		USAtoEngNetworkAdapter adapter = new USAtoEngNetworkAdapter(usaConnector);

		station.connect(adapter);
	}
}
