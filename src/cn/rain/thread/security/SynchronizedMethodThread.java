package cn.rain.thread.security;

/**  
* description:演示通过synchronized同步函数来解决线程安全问题
* @author 任伟  
* @date Mar 8, 2018
*/
public class SynchronizedMethodThread implements Runnable{

	private int ticketCount = 100;
	
	@Override
	public void run() {
		while (ticketCount > 0) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sale();
		}
	}
	
	public synchronized void sale(){
		if (ticketCount > 0) {
			System.out.println(Thread.currentThread().getName()
					+ "正在出售第" + (100-ticketCount+1) + "张票");
			ticketCount --;
			}
	}
}
