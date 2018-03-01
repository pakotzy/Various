package com.pakotzy.various.feature;

import com.pakotzy.various.event.Event;

import javax.validation.Valid;
import java.util.List;

public abstract class Feature {
	@Valid
	private List<? extends Event> events;

	public abstract void initialize();
	public abstract void run();
	public abstract void stop();

	public List<? extends Event> getEvents() {
		return events;
	}

	public void setEvents(List<? extends Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Feature{\n" +
				events +
				'}';
	}
}
