package cn.rain.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * description: 这是一个定长的，支持定时延迟执行及周期性任务执行的线程池，
 * 若想使用其定时功能，就不要再调用execute方法了，应该调用schedule方法。
 * 
 * @author 任伟
 * @date Mar 13, 2018
 */
public class SchedulePoolDemo {
	public static void main(String[] args) {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
		for (int i = 0; i < 10; i++) {
			int temp = i;
			newScheduledThreadPool.schedule(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程名: " + Thread.currentThread().getName() 
							+ "在执行第" + ( temp+1 ) + "个任务");		
				}
			/*
			 * 这里要着重说明这个定时，这里设置的时间不是说线程被创建后延迟几秒再执行任务，
			 * 因为线程池中的线程是在线程池一创建的时候就被创建好了，试想如果之间隔了好久都没有任务要执行，
			 * 那么要怎么算这个时间，再者说，我们这10个任务，每个任务被哪条线程执行也是不确定的，
			 * 因次这个定时和线程的创建时间毫无关系，其实这个定时是调用这个schedule（Runnable target）方法后，
			 * 这个传入的target在调用这个方法的多长时间后，去执行这个target。
			 */
			}, temp, TimeUnit.SECONDS); 
		}
		newScheduledThreadPool.shutdown();
	}
}
