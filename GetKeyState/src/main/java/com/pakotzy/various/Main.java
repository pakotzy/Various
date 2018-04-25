package com.pakotzy.various;

import com.sun.jna.platform.win32.User32;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        User32 user32 = User32.INSTANCE;
        Thread.sleep(1000);
	    short state = user32.GetAsyncKeyState(0x10);
//	    Returns 1 if Shift is not hold, 0 on error, some numbers otherwise
	    System.out.println(state);
    }
}
