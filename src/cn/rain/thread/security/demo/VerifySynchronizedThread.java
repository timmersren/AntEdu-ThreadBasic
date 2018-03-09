package cn.rain.thread.security.demo;

/**
 * description:证明同步函数使用的是this锁
 * @author 任伟
 * @date Mar 9, 2018
 */
public class VerifySynchronizedThread implements Runnable {

	private static int train1Count = 100;
	private Object obj = new Object();
	public boolean flag = true;

	@Override
	public void run() {
		if (flag) {
			// 执行同步代码块this锁
			while (train1Count > 0) {
				synchronized (obj) {
					if (train1Count > 0) {
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - train1Count + 1) + "票");
						train1Count--;
					}
				}

			}
		} else {
			// 执行同步函数
			while (train1Count > 0) {
				sale();
			}
		}

	}

	public synchronized void sale() {
		if (train1Count > 0) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - train1Count + 1) + "票");
			train1Count--;
		}
	}
}
