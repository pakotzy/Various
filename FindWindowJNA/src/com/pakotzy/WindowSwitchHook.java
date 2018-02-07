package com.pakotzy;

import com.sun.jna.platform.win32.*;

public final class WindowSwitchHook {

	private final User32 user32 = User32.INSTANCE;
	private final Kernel32 kernel32 = Kernel32.INSTANCE;

	private WinNT.HANDLE wsHook;

	private boolean isHooked = false;

	private final WinUser.WinEventProc wsHookP = (handle, event, hwnd, aLong, aLong1, dword1, dword2) -> {
		String name = WindowInfo.getWindowName(hwnd);
		System.out.println(name);
	};

	public void start() {
		setHook();
		read();
	}

	public void stop() {
		removeHook();
	}

	private void read() {
		WinUser.MSG msg = new WinUser.MSG();
		while ((user32.GetMessage(msg, null, 0, 0)) != 0) {
			if (!isHooked) {
				break;
			}
		}
	}

	private void removeHook() {
		if (isHooked) {
			user32.UnhookWinEvent(wsHook);
			isHooked = false;
		}
	}

	private void setHook() {
		if (!isHooked) {
			wsHook = user32.SetWinEventHook(3,3, kernel32.GetModuleHandle(null), wsHookP, 0, 0, 0);
			isHooked = true;
		} else {
			System.out.println("The Hook is already installed.");
		}
	}
}