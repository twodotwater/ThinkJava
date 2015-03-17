package com.lzhn.thread;

import java.util.concurrent.TimeUnit;

public class Daemon {
	public static void main(String[] args) {
		Thread t = new Thread(new DaemonRunable());
		t.setDaemon(true);// 后台线程、在其中创建的新线程默认也是后台线程
		t.start();
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class DaemonRunnable2 implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread());
			Thread.yield();
		}
	}

}

class DaemonRunable implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				Thread thread = new Thread(new DaemonRunnable2());
				thread.start();
				System.out.println("isDaemon: " + thread.isDaemon());
			}
		} catch (Exception e) {

		} finally {
			System.out.println("fianlly");
		}
	}

}