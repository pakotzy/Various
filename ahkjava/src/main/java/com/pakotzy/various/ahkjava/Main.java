package com.pakotzy.various.ahkjava;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.win32.W32APIOptions;

import java.io.IOException;
import java.util.Arrays;

public class Main {
	public interface autoHotKeyDll extends Library {
		public void ahkExec(WString s);
		public void ahkdll(WString s,WString o,WString p);
		public void addFile(WString s, int a);
		public void ahktextdll(WString s,WString o,WString p);
		public Pointer ahkFunction(WString f, WString p1, WString p2, WString p3, WString p4, WString p5, WString p6, WString p7, WString p8, WString p9, WString p10);
	}

	public static void main(String args[]) throws InterruptedException, IOException {
		loadExe();
		killByName("AutoHotkey.exe");
//		loadDll();
	}

	private static void loadExe() throws IOException, InterruptedException {
		String ahkPath =  "C:\\Program Files\\AutoHotkey\\AutoHotkey.exe";
		String scriptPath = "D:\\Files\\PoE\\POE-TradeMacro\\Run_TradeMacro.ahk";

		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(new String[] { ahkPath, scriptPath } );
		Thread.currentThread();
		Thread.sleep(10000);
		if (process.isAlive()) {
			System.out.println("Alive");
			process.destroyForcibly();
		}
//		runtime.exit(1);
	}

	private static void loadDll() throws InterruptedException {
		String dllPath =  "AHK1\\AutoHotkey.dll";
		String scriptPath = "D:\\Files\\PoE\\POE-TradeMacro\\_TradeMacroMain.ahk";

		System.out.println("running in " + System.getProperty("sun.arch.data.model"));

		System.out.println("Loading dll");
		autoHotKeyDll lib = Native.loadLibrary(dllPath, autoHotKeyDll.class);


		System.out.println("initialisation");
		lib.ahktextdll(new WString(""),new WString(""),new WString("")); // start new thread
		lib.addFile(new WString(scriptPath),1);
	}

	public static boolean killByName(String name) {

		Kernel32 kernel32 = Native.loadLibrary(Kernel32.class, W32APIOptions.UNICODE_OPTIONS);
		Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();

		WinNT.HANDLE snapshot = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
		try
		{
			int i = 0;

			int size = processEntry.dwSize.intValue();

			while (kernel32.Process32Next(snapshot, processEntry) && i < size) {
				System.out.println(processEntry.szExeFile);
				if (Arrays.equals(name.toCharArray(), Arrays.copyOfRange(processEntry.szExeFile, 0, name.length()))) {
					System.out.println("killing");

					WinNT.HANDLE  handle = Kernel32.INSTANCE.OpenProcess (
							0x0400| /* PROCESS_QUERY_INFORMATION */
									0x0800| /* PROCESS_SUSPEND_RESUME */
									0x0001| /* PROCESS_TERMINATE */
									0x00100000 /* SYNCHRONIZE */,
							false,
							processEntry.th32ProcessID.intValue());
					kernel32.TerminateProcess(handle, 1);
					return true;
				}
				i++;
			}

		}
		finally
		{
			kernel32.CloseHandle(snapshot);
		}
		return false;
	}
}
