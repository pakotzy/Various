package com.pakotzy.various.Behavioral.Observer;

public interface Observable {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}
