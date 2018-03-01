package com.pakotzy.various.event;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class GenericEvent extends Event {
	@NotNull
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "GenericEvent{" +
				"action='" + action + '\'' +
				", hotKey='" + getHotKey() + '\'' +
				", enabled=" + isEnabled() +
				'}';
	}
}
