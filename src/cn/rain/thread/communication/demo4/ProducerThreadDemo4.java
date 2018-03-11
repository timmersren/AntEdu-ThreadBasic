package cn.rain.thread.communication.demo4;


/**
 * description: 使用java并发包中的lock锁来完成手动上锁
 * @author 任伟
 * @date Mar 11, 2018
 */
public class ProducerThreadDemo4 implements Runnable {

	private ShareDate user;

	public ProducerThreadDemo4(ShareDate user) {
		super();
		this.user = user;
	}

	@Override
	public void run() {
		int count = 0; // 使用count来控制生产哪个user
		while (true) {
			try {
				user.getLock().lock();
				if (user.isFlag()) {
					user.getCondition().await();
				}
				Thread.sleep(500);
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
				user.getCondition().signal();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				user.getLock().unlock();
			}
		}
	}

}
