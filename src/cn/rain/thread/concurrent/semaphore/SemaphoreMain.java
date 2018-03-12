package cn.rain.thread.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * description: Semaphore是一种基于计数 信号量。它可以设定一个阈值。
 * 基于此，多个线程竞争获取许可信号，做自己的申请后归还，超过阈值后，线程申请许可信号将会被阻塞。
 * 我们也可以创建阈值为1的Semaphore，将其作为一种类似互斥锁的机制，这也叫二元信号量，表示两种互斥状态。
 * @author 任伟
 * @date Mar 12, 2018
 */
public class SemaphoreMain {
	public static void main(String[] args) {
		Semaphore wc = new Semaphore(3);
		for(int i = 1; i < 11; i++){
			SemaphoreThread thread = new SemaphoreThread(i + "号", wc);
			Thread t = new Thread(thread);
			t.start();
		}
	}
}
