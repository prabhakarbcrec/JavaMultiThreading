package com.java.thread.learing;

import java.util.Map.Entry;

class threadExcuter implements Runnable {

	@Override
	public void run() {
		System.out.println("i am a thread");

	}

}

public class ThreadCreationUsingImplementRunnableInterface {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread t = new Thread(new threadExcuter());
			t.setName("thread-" + i);
			t.start();

		}
		for (Thread ThreadInfo : Thread.getAllStackTraces().keySet()) {
			System.out.println(ThreadInfo.getState() + "  " + ThreadInfo.getName());
		}
	}
}
