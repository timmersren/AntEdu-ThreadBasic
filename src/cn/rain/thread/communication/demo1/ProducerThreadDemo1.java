package cn.rain.thread.communication.demo1;

/**
 * 线程间通信的生产者线程
 */
public class ProducerThreadDemo1 implements Runnable {
	
	private ShareUserDemo1 user;
	
	public ProducerThreadDemo1(ShareUserDemo1 user) {
		this.user = user;
	}
	
	@Override
	public void run() {
		int count = 0; // 使用count来控制生产哪个user
		while (true) {
			if (count == 0) {
				user.setUsername("大力");
				user.setGender("男");
			} else {
				user.setUsername("小兰");
				user.setGender("女");
			}
			count = (count + 1) % 2;
		}
	}
}
