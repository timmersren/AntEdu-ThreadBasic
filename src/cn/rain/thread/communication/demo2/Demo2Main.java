package cn.rain.thread.communication.demo2;

import cn.rain.thread.communication.demo1.ShareUserDemo1;

/**
 * description: 演示将生产过程和消费过程同步，这样就不会使消费者读出的数据错乱了。
 * 但是这里又引出了一个问题，那就是抢夺CPU执行权的问题，如果生产者多次抢到执行权，
 * 那么就产生了多次生产单没有消费的情形;同理，如果消费者多次抢到执行权，那么就产生了
 * 多次消费旧数据，而一直没有新数据再生产出来的情形。这不是我们希望得到的最终结果，
 * 我们希望的是，生产者生产一条数据，消费者就将其消费掉，然后生产者再生产下一条新的数据，
 * 消费者再将新数据进行消费，如此往复。这就引出了java多线程中的 等待-唤醒（wait、notify）机制。
 * 详见Demo3
 * 
 * @author 任伟
 * @date Mar 11, 2018
 */
public class Demo2Main {
	public static void main(String[] args) {
		ShareUserDemo1 user = new ShareUserDemo1();
		
		ProducerThreadDemo2 producer = new ProducerThreadDemo2(user);
		ConsumerThreadDemo2 consumer = new ConsumerThreadDemo2(user);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		//为了让生产者先生产初始数据（不然的话没生产就消费，会读出来的数据为null），让消费者等上50ms再启动
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		consumerThread.start();
	}

}
