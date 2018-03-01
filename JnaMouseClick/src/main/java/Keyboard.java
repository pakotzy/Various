import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

public class Keyboard {
	public static void main(String[] args) throws InterruptedException {
		int pluscode = 0x4E;
		int minuscode = 0x4A;

		int extended = 0x0001;
		int released = 0x0002;
		int scancode = 0x0008;
		Thread.sleep(5000);
		User32 user32 = User32.INSTANCE;
		WinUser.INPUT input = new WinUser.INPUT();
		input.type = new WinUser.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
		input.input.setType("ki");
		input.input.ki.wScan = new WinUser.WORD(pluscode);
//		input.input.ki.dwFlags = new WinDef.DWORD(scancode);
//		WinDef.DWORD inserted = user32.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input
//				.size());
//		System.out.println(inserted.intValue() == 1 ? "SendInput down" : "SendInput down unsuccessful");
//		Thread.sleep(10000);
//		input.input.ki.dwFlags = new WinDef.DWORD(scancode | released);
//		inserted = user32.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input
//				.size());
//		System.out.println(inserted.intValue() == 1 ? "SendInput down" : "SendInput down unsuccessful");
		for (int i = 0; i < 1000; i++) {
			input.input.ki.dwFlags = new WinDef.DWORD(scancode);
			WinDef.DWORD inserted = user32.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input
					.size());
			System.out.println(inserted.intValue() == 1 ? "SendInput down" : "SendInput down unsuccessful");
			input.input.ki.dwFlags = new WinDef.DWORD(scancode | released);
			Thread.sleep(1);
			inserted = user32.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input
					.size());
			System.out.println(inserted.intValue() == 1 ? "SendInput down" : "SendInput down unsuccessful");
		}
	}
}
