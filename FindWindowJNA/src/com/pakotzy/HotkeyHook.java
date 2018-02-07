package com.pakotzy;

import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

public class HotkeyHook {
	private final User32 user32 = User32.INSTANCE;
	private final Kernel32 kernel32 = Kernel32.INSTANCE;

	private final int PID = 0;
	private final WinUser.HMODULE hMod = kernel32.GetModuleHandle(null);

	private HotkeyHook() {
		start();
	}

	public static void main(String[] args) {
		new HotkeyHook();
	}

	private void start() {
		WinDef.HWND hwnd = WindowInfo.getActive();
		user32.RegisterHotKey(hwnd, 0, WinUser.MOD_ALT | WinUser.MOD_NOREPEAT, 45);
	}
}
