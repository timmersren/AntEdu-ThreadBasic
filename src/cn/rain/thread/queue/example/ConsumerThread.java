package cn.rain.thread.queue.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * description: 使用队列实现生产者消费者模型--消费者线程
 * @author 任伟
 * @date Mar 12, 2018
 */
public class ConsumerThread implements Runnable{
	
	private BlockingQueue<Integer> queue;
	private volatile boolean flag = true;

	public ConsumerThread(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("消费者线程启动...");
		try {
			while (flag) {
				System.out.println("消费者,正在从队列中获取数据...");
				Integer data = queue.poll(2, TimeUnit.SECONDS);
				if (data != null) {
					System.out.println("消费者,拿到队列中的数据data:" + data);
					Thread.sleep(1000);
				} else {
					System.out.println("消费者,超过2秒未获取到数据..");
					stop();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("消费者退出线程...");
		}
	}
	public void stop(){
		flag = false;
	}
}
