package cn.rain.thread.security.demo;

/**
 * description: 演示死锁的Main函数
 * 
 * @author 任伟
 * @date Mar 8, 2018
 */
public class SellTicketMain {

	public static void main(String[] args) {
		
		DeadSynchronizedThread thread = new DeadSynchronizedThread();

		Thread t1 = new Thread(thread, "窗口1--");
		Thread t2 = new Thread(thread, "窗口2--");
		t1.start();
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.flag = false;
		t2.start();
	}
}
