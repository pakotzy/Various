package com.pakotzy;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		WindowSwitchHook wh = new WindowSwitchHook();
		Thread th = new Thread(wh::start);
		th.start();

		Thread.sleep(15 * 1000);

		wh.stop();
		th.interrupt();
		th = null;
	}
}
