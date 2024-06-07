package com.java.thread.learing;

public class createThreadUsingLambda {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			System.out.println("aa gya tere baap");
		});
		t.start();
	}
}
