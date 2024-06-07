package com.java.thread.learing;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class StringCaseChecker {
	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader(new File(
				"C:\\\\Users\\\\prabh\\\\eclipse-workspace\\\\javaThread\\\\src\\\\com\\\\java\\\\thread\\\\learing\\\\data.txt"));
		String data = "my name is kaka, PP mar k bhaga";
		StringCheckerThread checker = new StringCheckerThread(data, file);
		Thread t = new Thread(checker);
		t.start();
		t.join();
		System.out.println("\nMain Thread job completed");
	}

}

class PrinterThread implements Runnable {
	char c;
	FileWriter file;
	int index = 0;

	public PrinterThread(char c, FileWriter file, int index) {
		this.c = c;
		this.file = file;
		this.index = index;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			file.write(String.valueOf(c), index, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.print(StringCheckerThread.toUpper(c));

	}

}

class StringCheckerThread implements Runnable {
	char[] data;
	FileReader file;

	public StringCheckerThread(String data, FileReader file) {
		this.data = data.toCharArray();
		this.file = file;
	}

	@Override
	public void run() {
		FileWriter file = null;
		try {
			file = new FileWriter(new File(
					"C:\\Users\\prabh\\eclipse-workspace\\javaThread\\src\\com\\java\\thread\\learing\\data.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrinterThread threadP;
		int c;
		int index = 0;
		try {
			while ((c = this.file.read()) != -1) {
				char ch = (char) c;
				index++;
				if (isLower(ch)) {
					threadP = new PrinterThread(ch, file, index);
					Thread t2 = new Thread(threadP);
					t2.start();
					try {
						t2.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.print(c);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean isLower(char c) {
		return Character.isLowerCase(c);
	}

	public static char toUpper(char c) {
		return Character.toUpperCase(c);
	}
}