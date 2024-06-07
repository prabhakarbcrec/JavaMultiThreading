package com.java.thread.learing;

public class threadExtends {
	public static void main(String[] args) {
		System.out.println("Application started");
		t objc = new t();
		objc.start();
	}
}

class t extends Thread {

	public void run() {
		System.out.println("still i am running bro");
	}
}