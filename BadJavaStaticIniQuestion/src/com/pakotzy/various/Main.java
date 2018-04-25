package com.pakotzy.various;

class Test {
	static {
		if (true) {
			System.out.println("static");
			throw new NullPointerException();
		}
	}

	public static void run() {
		System.out.println("run");
	}
}

public class Main {

    public static void main(String[] args) {
	    try {
		    System.out.println("Try");
		    Test.run();
	    } catch (Throwable throwable) {
		    System.out.println("Catch");
	    	Test.run();
	    }
    }
}
