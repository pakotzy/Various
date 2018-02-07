package com.pakotzy;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

public class KeyEventHook {
	private final User32 user32 = User32.INSTANCE;
	private final Kernel32 kernel32 = Kernel32.INSTANCE;

	private final int PID = 0;
	private final WinUser.HMODULE hMod = kernel32.GetModuleHandle(null);

	private Thread thread;
	private WinUser.HHOOK hhk;

	private boolean isHooked = false;

	private final WinUser.LowLevelKeyboardProc kbHookProcLL = (i, wparam, kbdllhookstruct) -> {
		if (i >= 0) {
			switch(wparam.intValue()) {
				case WinUser.WM_KEYUP:
				case WinUser.WM_KEYDOWN:
				case WinUser.WM_SYSKEYUP:
				case WinUser.WM_SYSKEYDOWN:
					System.err.println("in callback, key=" + kbdllhookstruct.vkCode);
					if (kbdllhookstruct.vkCode == 81) {
						isHooked = true;
					}
			}
		}

		Pointer pointer = kbdllhookstruct.getPointer();
		long peer = Pointer.nativeValue(pointer);
		return user32.CallNextHookEx(null, i, wparam, new WinDef.LPARAM(peer));
	};

	public void start() {
		setHook();
	}

	public void stop() {
		removeHook();
	}

	private void setHook() {
		if (!isHooked) {
			hhk = user32.SetWindowsHookEx(WinUser.WH_KEYBOARD_LL, kbHookProcLL, hMod, PID);
		} else {
			System.out.println("The Hook is already installed.");
		}
	}

	private void removeHook() {
		new Thread(() -> {
			while (!isHooked) {
				try {
					Thread.sleep(1 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Unhook and exit!");
			user32.UnhookWindowsHookEx(hhk);
			if (thread.isAlive()) {
				thread.interrupt();
			}
			System.exit(0);
		}).start();
	}
}
