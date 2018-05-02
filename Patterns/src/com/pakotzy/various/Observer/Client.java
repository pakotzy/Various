package com.pakotzy.various.Observer;

import java.util.ArrayList;
import java.util.List;

public class Client implements Observer {
	private List<Show> shows = new ArrayList<>();
	private UpdateServer updateServer;

	public Client(UpdateServer updateServer) {
		this.updateServer = updateServer;
		updateServer.registerObserver(this);

		shows.add(new Show("The 100", 1, 1, "2018-05-01"));
		shows.add(new Show("Ozark", 1, 1, "2018-05-01"));
		shows.add(new Show("Game of Thrones", 1, 1, "2018-05-01"));
	}

	@Override
	public void update() {
		requestUpdate();
	}

	private void requestUpdate() {
		shows = updateServer.getShows(shows.stream().map(Show::getName).toArray(String[]::new));
	}

	@Override
	public String toString() {
		return "Client{" +
				"shows=" + shows +
				'}';
	}
}
