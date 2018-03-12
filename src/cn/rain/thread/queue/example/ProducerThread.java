package cn.rain.thread.queue.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description: 使用队列实现生产者消费者模型--生产者线程
 * @author 任伟
 * @date Mar 12, 2018
 */
public class ProducerThread implements Runnable {
	
	//共享数据（队列），由主线程传入，以便保证是相同的队列，从而让生产、消费线程共享队列中的数据
	private BlockingQueue<Integer> queue;
	//用于控制线程停止的标记符号
	private volatile Boolean flag = true;
	//模拟生产者生产的数据，这里使用原子的Integer，向队列中放入逐渐增加的数值
	private static AtomicInteger atomicInteger = new AtomicInteger();
	
	public ProducerThread(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "生产线程启动...");
		try {
			while (flag) {
				System.out.println(Thread.currentThread().getName() + "正在产生数据...");
				int data = atomicInteger.incrementAndGet();
				// 将数据存入队列
				boolean result = queue.offer(data, 2, TimeUnit.SECONDS);
				if (result) {
					System.out.println(Thread.currentThread().getName() + "生产线程成功将" + data + "存入队列中...");
				} else {
					System.out.println(Thread.currentThread().getName() + "生产线程存入" + data + "失败...");
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + "生产者退出线程");
		}
	}
	
	public void stop(){
		flag = false;
	}

}
