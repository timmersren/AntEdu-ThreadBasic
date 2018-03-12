package cn.rain.thread.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * description: 
 * @author 任伟
 * @date Mar 12, 2018
 */
public class CountThread1 implements Runnable {

	private CountDownLatch latch;
	
	public CountThread1(CountDownLatch latch) { //由主线程传入CountdownLatch
		this.latch = latch;
	}


	@Override
	public void run() {
		System.out.println("子线程" + Thread.currentThread().getName() + "开始执行任务");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕...");
		latch.countDown(); //调用countDown方法会让计数器每次减1
	}
}
