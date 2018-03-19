package cn.rain.thread.queue.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * description: 
 * @author 任伟
 * @date Mar 12, 2018
 */
public class QueueMain {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
		ProducerThread producerThread1 = new ProducerThread(queue);
		ProducerThread producerThread2 = new ProducerThread(queue);
		ConsumerThread consumerThread1 = new ConsumerThread(queue);
		
		Thread t1 = new Thread(producerThread1);
		Thread t2 = new Thread(producerThread2);
		Thread t3 = new Thread(consumerThread1);
		
		t1.start();
		t2.start();
		t3.start();
		
		//让程序执行10s
		Thread.sleep(10 * 1000);
		//停止生产者线程
		producerThread1.stop();
		producerThread2.stop();
	}
}
