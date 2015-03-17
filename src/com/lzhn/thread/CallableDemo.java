package com.lzhn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author lzhn
 * 
 */
public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Future<String> future = service.submit(new Inner());
		try {
			System.out.println(future.get());// 等待任务完成返回值
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 可接收线程返回值
	 */
	static class Inner implements Callable<String> {

		@Override
		public String call() throws Exception {
			System.out.println(Thread.currentThread());
			long previous = System.currentTimeMillis();
			System.out.println(previous);
			TimeUnit.SECONDS.sleep(5);
			System.out.println(System.currentTimeMillis() - previous);
			return "call";
		}

	}
}
