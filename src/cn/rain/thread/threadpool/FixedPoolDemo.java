package cn.rain.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description: 固定长度的线程池，我们可手动传入创建线程的最大数量。
 * 当需要执行的target（任务）超过线程的最大数量时，一部分target会进入队列等待，
 * 等待其他运行中的线程执行完任务后，再用这些线程来执行。
 * 
 * 注意：这种线程池在实际中是最常用到的，实际固定的线程数量要根据电脑硬件来配置，
 * 例如Runtime.getRuntime().availableProcessors()
 * 
 * @author 任伟
 * @date Mar 13, 2018
 */
public class FixedPoolDemo {
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			int temp = i;
			newFixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程名: " + Thread.currentThread().getName() 
							+ "在执行第" + ( temp+1 ) + "个任务");					
				}
			});
		}
		newFixedThreadPool.shutdown();
	}
}
