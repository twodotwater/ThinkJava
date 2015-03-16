package com.lzhn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread extends Thread {
	@Override
	public void run() {
		super.run();
		throw new RuntimeException(getName());
	}

	public static void main(String[] args) {
		try {
			new ExceptionThread().start();
		} catch (Exception e) {
			// 不能捕获
			System.out.println("Exception!");
		}
	}
}

class ExceptionRunnable implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException("hello");
	}

	public static void main(String[] args) {
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionRunnable());
		} catch (Exception e) {
			// 不能捕获
			System.out.println("Exception!");
		}
	}
}
