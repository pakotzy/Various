package com.pakotzy;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.IntByReference;

public class WindowInfo {
	private static User32 user32 = User32.INSTANCE;
	private static Psapi psapi = Psapi.INSTANCE;
	private static Kernel32 kernel32 = Kernel32.INSTANCE;
	private static final int MAX_TITLE_LENGTH = 1024;

	public static void getWindowInfo(HWND hwnd) {
		char[] buffer = new char[MAX_TITLE_LENGTH];
		user32.GetWindowText(hwnd, buffer, MAX_TITLE_LENGTH);
		System.out.println("Active window title: " + Native.toString(buffer));

		IntByReference pointer = new IntByReference();
		user32.GetWindowThreadProcessId(user32.GetForegroundWindow(), pointer);
		WinNT.HANDLE process = kernel32.OpenProcess(Kernel32.PROCESS_QUERY_INFORMATION | Kernel32.PROCESS_VM_READ, false, pointer.getValue());
		psapi.GetModuleFileNameExW(process, null, buffer, MAX_TITLE_LENGTH);
		System.out.println("Active window process: " + Native.toString(buffer));
	}

	public static String getWindowName(HWND hwnd) {
		char[] buffer = new char[MAX_TITLE_LENGTH];
		user32.GetWindowText(hwnd, buffer, MAX_TITLE_LENGTH);
		return Native.toString(buffer);
	}

	public static HWND getActive() {
		return User32.INSTANCE.GetForegroundWindow();
	}
}