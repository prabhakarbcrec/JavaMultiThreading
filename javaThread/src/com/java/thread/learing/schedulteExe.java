package com.java.thread.learing;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class schedulteExe {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		System.out.println("Task scheduled to execute after 10 seconds at : " + LocalDateTime.now().toString());
		Task task = new Task("App-Task");
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
		System.out.println(
				"Shutdown and await requested at : " + LocalDateTime.now().toString() + " " + result.get().toString());
		executor.shutdown();
		try {
			if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			executor.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}
}

class Task implements Runnable {
	private String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name+": Lo! Main phir se AA Gya, Sb khusi? bol naa.");

	}

}