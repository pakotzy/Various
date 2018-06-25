package com.pakotzy.various.Behavioral.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateServer implements Observable {
	private List<Observer> observers = new ArrayList<>();
	private Map<String, Show> shows = new HashMap<>();
	private boolean changed;

	public UpdateServer() {
		shows.put("The 100", new Show("The 100", 1, 1, "2018-05-01"));
		shows.put("Ozark", new Show("Ozark", 1, 1, "2018-05-01"));
		shows.put("American Gods", new Show("American Gods", 1, 1, "2018-05-01"));
		shows.put("Power", new Show("Power", 1, 1, "2018-05-01"));
		shows.put("Game of Thrones", new Show("Game of Thrones", 1, 1, "2018-05-01"));
		shows.put("Suits", new Show("Suits", 1, 1, "2018-05-01"));
	}

	@Override
	public void registerObserver(Observer o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}

	@Override
	public void notifyObservers() {
		if (changed) {
			for (Observer o : observers) {
				o.update();
			}
			changed = false;
		}
	}

	private void setChanged() {
		changed = true;
	}

	public void setShows(Show... shows) {
		for (Show show : shows) {
			this.shows.put(show.getName(), show);
		}

		setChanged();
		notifyObservers();
	}

	public List<Show> getShows(String... shows) {
		List<Show> result = new ArrayList<>();

		for (String name : shows) {
			if (this.shows.containsKey(name)) {
				result.add(this.shows.get(name));
			}
		}

		return result;
	}
}
