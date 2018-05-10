package com.pakotzy.various.Command;

public class Boss {
	private Command[] workers = new Command[3];

	public Boss() {
		for (int i = 0; i < 3; i++) {
			workers[i] = () -> {};
		}
	}

	public void setWorker(int id, Command worker) {
		if (id >= workers.length) {
			return;
		}

		workers[id] = worker;
	}

	public void makeMoney(int id) {
		if (id >= workers.length) {
			return;
		}

		workers[id].execute();
	}
}
