package com.java.thread.learing;

public class JOIN {
	public static void main(String[] args) {
		threadJoing threadj = new threadJoing();
		threadj.start();
		try {
			threadj.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mian thrad completed:");

	}
}

class threadJoing extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("child thread execution - " + i);

		}
	}
}
