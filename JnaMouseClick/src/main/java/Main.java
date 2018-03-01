import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

import java.awt.*;
import java.awt.event.InputEvent;

public class Main {
	public static final int WM_LBUTTONUP = 514;
	public static final int WM_LBUTTONDOWN = 513;
	public static final int WM_LBUTTONDBLCLK = 0x203;
	static int WM_CLOSE = 0x10;
	final static String winTitle = "Untitled - Notepad";

	public static void main(String[] args) throws InterruptedException {
		User32 user32 = User32.INSTANCE;
		Thread.sleep(5000);
//		try {
//			Robot robot = new Robot();
//			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//			System.out.println("Robot Down");
//			Thread.sleep(5000);
//			robot.mouseRelease(InputEvent.BUTTON1_MASK);
//			System.out.println("Robot Up");
//		} catch (AWTException e) {
//			e.printStackTrace();
//		}

		WinDef.DWORD inputs = new WinDef.DWORD(1);
		WinUser.INPUT input = new WinUser.INPUT(  );

		input.type = new WinDef.DWORD(WinUser.INPUT.INPUT_MOUSE);
		input.input.setType("mi");
		input.input.mi.mouseData = new WinDef.DWORD(0);
		input.input.mi.dwFlags = new WinDef.DWORD(2|4);

		WinDef.DWORD inserted = user32.SendInput(inputs, (WinUser.INPUT[]) input.toArray(1), input.size());
		System.out.println(inserted.intValue() == 1 ? "SendInput down" : "SendInput down unsuccessful");
//		Thread.sleep(5000);
//		input.input.mi.dwFlags = new WinDef.DWORD(4);
//		inserted = user32.SendInput(inputs, (WinUser.INPUT[]) input.toArray(1), input.size());
//		System.out.println(inserted.intValue() == 1 ? "SendInput up" : "SendInput up unsuccessful");
	}
}
