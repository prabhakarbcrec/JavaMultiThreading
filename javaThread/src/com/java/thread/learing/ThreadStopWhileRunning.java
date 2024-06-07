package com.java.thread.learing;

class manageThread implements Runnable {
	Thread t = null;
	boolean exit;
	private String name;

	public manageThread(String threadName) {
		name = threadName;
		t = new Thread(this, name);
		System.out.println("New thread: " + t);
		exit = false;
		t.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (!exit) {
			System.out.println("I am thread " + t.getName() + " my count is " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Caught:" + e);
			}
			i++;
		}
		System.out.println(name + " Stopped.");
		System.out.println(name+" has stoped, now rohit will on  as he alived");

	}

	public void stopFlasControl() {
		exit = true;
	}

}

public class ThreadStopWhileRunning {
	public static void main(String[] args) {
		manageThread t1 = new manageThread("Prabhakar");
		manageThread t2 = new manageThread("Rohit");
		try {
			
			
			t1.stopFlasControl();
			Thread.sleep(5000);
			t2.stopFlasControl();


		} catch (InterruptedException e) {
			System.out.println("Caught:" + e);
		}

	}
}