package cn.rain.thread;

/**
 * 守护线程：和主线程同时销毁。
 * 非守护线程：即使主线程销毁也会继续执行。
 * @author admin
 */
public class DaemonDemo {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
//					try {
//						Thread.sleep(30);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println(Thread.currentThread().getName() + " run: " + i);
				}		
			}
		}, "t1");
		t1.setDaemon(true);
		t1.start();
		for (int i = 0; i < 5; i++) {
//			try {
//				/**
//				 * 主线程这里最好加个和上面守护线程一样的等待时间，如果不加，那么在打印出"主线程执行完毕...."
//				 * 但是主线程还没有销毁之前的这个间隙，守护线程会继续执行，因此看不到效果。如果不加等待时间，
//				 * 就像现在这样注释掉了，那就把守护线程的循环次数设置大一些，我们就能看到当打印完""主线程执行完毕....""后
//				 * 守护线程再执行一会就结束了。出现这种情况的原因是，主线程并不是执行完最后那个输出语句就销毁了，
//				 * 后边还会执行一些东西（具体是什么暂时不知道），因此在输出语句和真正销毁前还有一些时间间隔。
//				 */
//				
//				Thread.sleep(30);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println("Main run: " + i);
		}
		System.out.println("主线程执行完毕....");
	}
}
