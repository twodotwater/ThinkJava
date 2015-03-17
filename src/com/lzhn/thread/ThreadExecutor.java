package com.lzhn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {
	public static void main(String[] args) {
		// Threads that have not been used for sixty seconds are terminated and
		// removed from the cache.
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			service.execute(new CountRunnable());
		}
		service.shutdown();
	}
}

class CountRunnable implements Runnable {
	private static int count = 0;
	private static int tickets = 100;
	private int id = count++;

	public void print() {
		while (tickets > 0) {
			System.out.println("id: " + id + " sales " + tickets--
					+ " tickets.");
			Thread.yield();
		}
	}

	@Override
	public void run() {
		print();
	}

}