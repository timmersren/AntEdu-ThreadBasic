package cn.rain.thread.communication.demo3;

/**
 * description: 消费者线程，使用wait-notify机制。
 * @author 任伟
 * @date Mar 11, 2018
 */
public class ConsumerThreadDemo3 implements Runnable {

	private ShareUserDemo3 user;
	
	
	public ConsumerThreadDemo3(ShareUserDemo3 user) {
		this.user = user;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (user) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (!user.isFlag()) {
					try {
						user.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				String username = user.getUsername();
				String gender = user.getGender();
				System.out.println("消费者读取：" + username + "---" + gender);
				user.setFlag(false);
				user.notify();
			}
			
		}
	}

}
