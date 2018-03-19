package cn.rain.thread.concurrent.cylicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * description: 
 * @author 任伟
 * @date Mar 12, 2018
 */
public class WriteDateThread implements Runnable {

	private CyclicBarrier barrier;
	
	public WriteDateThread(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始写入数据...");
		try {
			barrier.await(); //通过调用await方法在此处设置栅栏，使得线程执行到此进入阻塞状态等待其他线程执行完成。
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "写入数据完毕!");
	}
}
