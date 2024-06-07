package com.java.thread.learing;

import java.util.ArrayList;
import java.util.List;

public class consumarPoduceHandler {
	public static void main(String[] args) {
		System.out.println();
		List<Integer> broker = new ArrayList<Integer>();
		int size = 5;
		Thread proThread = new Thread(new producer(size, broker));
		Thread conThread = new Thread(new consumer(broker));
		proThread.start();
		conThread.start();

	}
}

class consumer implements Runnable {
	List<Integer> queueBroker;

	public consumer(List<Integer> queueBroker) {
		this.queueBroker = queueBroker;
	}

	@Override
	public void run() {
		while (true) {
			conMethod();
		}
	}

	private void conMethod() {
		synchronized (queueBroker) {

			if (queueBroker.isEmpty()) {
				try {
					queueBroker.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int value = queueBroker.remove(0);
			System.out.println("consumed  " + value);
			queueBroker.notifyAll();
		}
	}

}

class producer implements Runnable {
	int size;
	List<Integer> queueBroker;

	public producer(int size, List<Integer> queueBroker) {
		this.size = size;
		this.queueBroker = queueBroker;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			produceDone(count++);
		}
	}

	private void produceDone(int count) {
		synchronized (queueBroker) {

			if (queueBroker.size() >= size) {
				try {
					queueBroker.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("produced " + count);
			queueBroker.add(count);
			queueBroker.notifyAll();

		}
	}

}