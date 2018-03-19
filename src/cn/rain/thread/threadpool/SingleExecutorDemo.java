package cn.rain.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description: 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(可指定为FIFO, LIFO, 优先级)执行。
 * 
 * @author 任伟
 * @date Mar 13, 2018
 */
public class SingleExecutorDemo {
	public static void main(String[] args) {
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			int temp = i;
			newSingleThreadExecutor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程名: " + Thread.currentThread().getName() 
							+ "在执行第" + ( temp+1 ) + "个任务");	
				}
			});
		}
		newSingleThreadExecutor.shutdown();
	}
}
