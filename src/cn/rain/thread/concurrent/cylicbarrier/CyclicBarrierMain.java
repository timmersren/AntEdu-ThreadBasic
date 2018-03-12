package cn.rain.thread.concurrent.cylicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * description: 我们现在需要5个线程进行读入数据，在5条线程内写入完数据后，
 * 会打印写入完毕，如果我们不做任何操作，那么可能会发生某条线程先写入完毕，
 * 然后其他现在才开始写人的结果，这不是我们想要的。
 * 我们希望这5条线程写入完毕的先不要执行写入完毕，而是等待其他线程都写好了以后，
 * 一起执行写入完毕。这就需要引入CyclicBarrier（同步屏障）了，它可以让线程在调用
 * CyclicBarrier的await方法出阻塞，当其他线程都执行完毕后，再并行向下执行。
 * @author 任伟
 * @date Mar 12, 2018
 */
public class CyclicBarrierMain {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(4);
		for (int i = 0; i < 5; i++) {
			WriteDateThread thread = new WriteDateThread(barrier);
			Thread t = new Thread(thread);
			t.start();
		}
	}
}
