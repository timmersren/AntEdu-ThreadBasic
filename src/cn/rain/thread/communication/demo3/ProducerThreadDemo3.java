package cn.rain.thread.communication.demo3;

/**
 * description: 生产者线程，使用wait-notify机制。
 * @author 任伟
 * @date Mar 11, 2018
 */
public class ProducerThreadDemo3 implements Runnable {

	private ShareUserDemo3 user;
	
	public ProducerThreadDemo3(ShareUserDemo3 user) {
		this.user = user;
	}

	@Override
	public void run() {
		int count = 0; // 使用count来控制生产哪个user
		while (true) {
			synchronized (user) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//如果flag为true，那么生产者调用锁的wait方法，等待消费者消费完成。
				if (user.isFlag()) { 
					try {
						//此线程调用wait后，那么它会一直等待，知道持有该锁的其他线程使用notify将其唤醒。
						user.wait(); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (count == 0) {
					System.out.println("生产者将user设置成了 大力-男");
					user.setUsername("大力");
					user.setGender("男");
				} else {
					System.out.println("生产者将user设置成了 小兰-女");
					user.setUsername("小兰");
					user.setGender("女");
				}
				count = (count + 1) % 2;
				user.setFlag(true);
				user.notify();
			}
		}
	}

}
