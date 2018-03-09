package cn.rain.thread.security.demo;

/**
 * description: 演示开启两个线程售票
 * 
 * @author 任伟
 * @date Mar 8, 2018
 */
public class SellTicketMain {

	public static void main(String[] args) {
		// 线程不安全
//		TicketThread ticketThread = new TicketThread();

		// 使用synchronized同步代码块解决线程安全问题
//		 SynchronizedBlockThread blockThread = new SynchronizedBlockThread();

		// 使用同步函数解决线程安全问题
//		 SynchronizedMethodThread methodThread = new SynchronizedMethodThread();
		
//		VerifySynchronizedThread thread = new VerifySynchronizedThread();
		
		StaticSynchronizedThread thread = new StaticSynchronizedThread();

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
