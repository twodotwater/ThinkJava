package com.lzhn.thread;

import java.util.Scanner;

public class ResponsiveUI extends Thread {
	private static volatile double d = 1;

	public ResponsiveUI() {
		// setDaemon(true);
		start();
	}

	@Override
	public void run() {
		super.run();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("d: " + d);
			if (d <= 0) {
				System.out.println("stop!");
				break;
			}
			d = scanner.nextDouble();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ResponsiveUI responsiveUI = new ResponsiveUI();
		System.out.println("main over!");
	}
}