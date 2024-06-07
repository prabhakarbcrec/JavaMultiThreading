package com.java.thread.learing;

class abc implements Runnable {

	@Override
	public void run() {
		System.out.println("I am thread");

	}

}

public class Main {
	public static void main(String[] args) {
		Thread thread = new Thread(new abc());
		thread.start();
	}
}
