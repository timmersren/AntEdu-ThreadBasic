package cn.rain.thread.communication.demo3;

/**
 * description: 通过wait-notify机制，使生产者生产一个消费者就消费一个，
 * 消费完一个再生产一个新的然后再消费，如此往复。
 * @author 任伟
 * @date Mar 11, 2018
 */
public interface Demo3Main {
	public static void main(String[] args) {
		ShareUserDemo3 userDemo3 = new ShareUserDemo3();
		ProducerThreadDemo3 producerThreadDemo3 = new ProducerThreadDemo3(userDemo3);
		ConsumerThreadDemo3 consumerThreadDemo3 = new ConsumerThreadDemo3(userDemo3);
		
		Thread producer = new Thread(producerThreadDemo3);
		Thread consumer = new Thread(consumerThreadDemo3);
		producer.start();
		consumer.start();
	}
}
