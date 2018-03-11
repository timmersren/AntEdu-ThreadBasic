package cn.rain.thread.communication.demo1;

public class ConsumerThreadDemo1 implements Runnable {
	
	private ShareUserDemo1 user;
	
	public ConsumerThreadDemo1(ShareUserDemo1 user) {
		this.user = user;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String username = user.getUsername();
			String gender = user.getGender();
			System.out.println(username + "---" + gender);
		}
	}
}
