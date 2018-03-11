package cn.rain.thread.communication.demo4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description: 
 * @author 任伟
 * @date Mar 11, 2018
 */
public class Demo4Main {
	public static void main(String[] args) {
		// 使用重入锁实现Lock接口
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		// 将lock和condition传入共享数据类中，以便让线程间使用的是同一把锁
		ShareDate user = new ShareDate(lock, condition);

		ProducerThreadDemo4 producerThreadDemo4 = new ProducerThreadDemo4(user);
		ConsumerThreadDemo4 consumerThreadDemo4 = new ConsumerThreadDemo4(user);

		Thread producer = new Thread(producerThreadDemo4);
		Thread consumer = new Thread(consumerThreadDemo4);

		producer.start();
		consumer.start();
	}
}
