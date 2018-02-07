package com.pakotzy;

import com.sun.jna.Native;
import com.sun.jna.platform.DesktopWindow;
import com.sun.jna.platform.WindowUtils;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.*;
import com.sun.jna.win32.W32APIOptions;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;

public class TryJNA {

	public static void main(String[] args) {
		getActive();
		System.out.println("\n\n\n/-----------------/\n\n\n");
		System.out.println(execDuration("POEHelper", n -> isExistsStock(n)).toString());
		System.out.println(execDuration("POEHelper", n -> isExists(n)).toString());
	}

	public static boolean isExists(String name) {
		return !User32.INSTANCE.EnumWindows((hWnd, arg1) -> {
			char[] buffer = new char[20];
			User32.INSTANCE.GetWindowText(hWnd, buffer, 20);
			String wText = Native.toString(buffer);

			return wText.equals(name) ? false : true;
		}, null);
	}

	public static void getActive() {
		char[] buffer = new char[20];
		WinDef.HWND hwnd = User32.INSTANCE.GetForegroundWindow();
		User32.INSTANCE.GetWindowText(hwnd, buffer, 20);

		System.out.println(Native.toString(buffer));
	}

	public static boolean isExistsStock(String name) {
		List<DesktopWindow> windows = WindowUtils.getAllWindows(true);
		for (DesktopWindow window : windows) {
			if(window.getTitle().equals(name))
				return true;
		}

		return false;
	}

	public static <T, V> V execDuration(T name, Function<T, V> fn) {
		Instant start = Instant.now();
		V result = fn.apply(name);
		Instant end = Instant.now();
		Duration dur = Duration.between(start, end);
		System.out.println(dur.toMillis());
		return result;
	}
}