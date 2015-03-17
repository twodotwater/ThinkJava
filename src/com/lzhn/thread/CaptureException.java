package com.lzhn.thread;

import java.util.concurrent.ThreadFactory;

/**
 * 捕获非受检异常
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + t + " --> " + e);
	}

}

class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		System.out.println("HandlerThreadFactory");
		Thread t = new Thread(r);
		System.out.println("created " + t);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("handler --> " + t.getUncaughtExceptionHandler());
		return t;
	}

}

class ExceptionRunnable2 implements Runnable {

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run by : " + t);
		System.out.println("handler --> " + t.getUncaughtExceptionHandler());
		throw new RuntimeException("runtime exception!");
	}

}

public class CaptureException {
	public static void main(String[] args) {
		// ExecutorService exec = Executors
		// .newCachedThreadPool(new HandlerThreadFactory());
		// exec.execute(new ExceptionRunnable2());
		ExceptionRunnable2 exceptionRunnable2 = new ExceptionRunnable2();
		Thread t = new Thread(exceptionRunnable2, "hello");
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		t.start();
	}
}