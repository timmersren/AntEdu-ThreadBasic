package cn.rain.thread.communication.demo2;

import cn.rain.thread.communication.demo1.ShareUserDemo1;

/**
 * description: 消费者线程，将消费过程同步。
 * @author 任伟
 * @date Mar 11, 2018
 */
public class ConsumerThreadDemo2 implements Runnable{
	
	private ShareUserDemo1 user;

	public ConsumerThreadDemo2(ShareUserDemo1 user) {
		this.user = user;
	}
	
	@Override
	public void run() {
			while (true) {
				/*
				 * 这里一定要注意，synchronized绝对不能加在while外面。
				 * 因为你要是加在外面，一旦消费者拿到了执行权那么它将拿到执行权，
				 * 然后进入synchronized代码块中的死循环一直执行，并且永远也不会再释放锁。
				 * 因为这个synchronized代码块永远也执行不完。
				 * */
				synchronized (user) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					String username = user.getUsername();
					String gender = user.getGender();
					System.out.println(username + "---" + gender);
				}
			}
	}
}
