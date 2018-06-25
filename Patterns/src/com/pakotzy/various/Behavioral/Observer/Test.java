package com.pakotzy.various.Behavioral.Observer;

public class Test {
	public static void main(String[] args) {
		UpdateServer updateServer = new UpdateServer();
		Client client = new Client(updateServer);
		System.out.println(client);
		updateServer.setShows(new Show("The 100", 1, 2, "2018-05-01"));
		System.out.println(client);
		updateServer.removeObserver(client);
		updateServer.setShows(new Show("The 100", 1, 3, "2018-05-01"));
		System.out.println(client);
	}
}
