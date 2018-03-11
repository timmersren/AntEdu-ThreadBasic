package cn.rain.thread.communication.demo4;

/**
 * description: 使用java并发包中的lock锁来完成手动上锁
 * @author 任伟
 * @date Mar 11, 2018
 */
public class ConsumerThreadDemo4 implements Runnable {
	
	private ShareDate user;
	
	public ConsumerThreadDemo4(ShareDate user) {
		this.user = user;
	}

	@Override
	public void run() {
		while (true) {
			try {
				user.getLock().lock();
				if (!user.isFlag()) {
					user.getCondition().await();
				}
				String username = user.getUsername();
				String gender = user.getGender();
				Thread.sleep(500);
				System.out.println("消费者读取：" + username + "---" + gender);
				user.setFlag(false);
				user.getCondition().signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				user.getCondition().signal();
			}
		}
	}
}
