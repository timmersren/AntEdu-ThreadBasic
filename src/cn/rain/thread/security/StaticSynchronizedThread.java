package cn.rain.thread.security;

/**  
* description:   
* @author 任伟  
* @date Mar 9, 2018
*/
public class StaticSynchronizedThread implements Runnable {
	private static int ticketCount = 100;
	public boolean flag = true;
	@Override
	public void run() {
		if (flag) {
			while (ticketCount > 0) {
				synchronized (StaticSynchronizedThread.class) { // 同步代码块
					if (ticketCount > 0) {
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - ticketCount + 1) + "票");
						ticketCount--;
					}
				}

			}
		} else {
			// 执行静态同步函数
			while (ticketCount > 0) {
				sale();
			}
		}

	}
	public static synchronized void sale() { //静态同步函数
		if (ticketCount > 0) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - ticketCount + 1) + "票");
			ticketCount--;
		}
	}
}
