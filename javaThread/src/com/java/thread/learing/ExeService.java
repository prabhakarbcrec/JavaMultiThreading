package com.java.thread.learing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeService {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(4);
		es.execute(() -> {
			System.out.println("tere 3 bhai aa gye bro");
		});
		
		es.execute(() -> {
			System.out.println("tere 3 bhai aa gye bro");
		});
		
		es.execute(() -> {
			System.out.println("tere 3 bhai aa gye bro");
		});
		
		es.execute(() -> {
			System.out.println("tere 3 bhai aa gye bro");
		});
		es.shutdown();
	}

}
