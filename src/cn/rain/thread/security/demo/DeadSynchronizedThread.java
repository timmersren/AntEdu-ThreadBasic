package cn.rain.thread.security.demo;

/**
 * description: 演示死锁情况的发生。
 * 看完下边对于线程的不通flag状态，会发生如下情景：
 * 当t1为true时，拿到obj锁，此时停住，obj锁未释放;此时t2为false，拿到this锁，进入sale()方法中继续执行，
 * 但是执行到47行的时候，发现t2需要拿到obj才能继续执行，但是此时obj被t1占用且未释放，因此t2等待t1执行完成并释放obj，
 * 于是cpu再次唤醒t1执行时，此时t1应该执行第31行的sale()方法了，但是由于sale()方法是同步函数使用的是this锁，
 * 但是此时this锁被t2持有且未释放，因此t1此时不能继续执行，拿着obj锁等待t2释放this锁后继续执行。然后cpu又唤醒了t2,
 * t2发现它自己拿着this锁，但是需要obj锁才能继续向下执行，但是obj被t1持有且没释放，如此无限往复，程序没有停止，但是却无法
 * 再继续执行。归根结底，t1拿着t2的锁，t2拿着t1的锁，t1释放了锁t2才能继续，t2释放了t1才能继续，互相就把对方堵死了。
 * @author 任伟
 * @date 2018年3月9日
 */
public class DeadSynchronizedThread implements Runnable {

	private int ticketCount = 100;
	private Object obj = new Object();
	public boolean flag = true;
	
	@Override
	public void run() {
		/**
		 * 如果线程flag为true，那么该线程需要：
		 * 1.先拿到obj锁进入同步代码块执行。
		 * 2.进入同步代码块后调用sale()时需要拿到同步函数的this锁。
		 */
		if (flag) {
			while(true){ 
				synchronized (obj) { //同步代码块，使用obj锁
					sale();
				}
			}
		}
		/**
		 * 如果线程flag为false，那么该线程需要:
		 * 1.调用sale()方法时要先拿到同步函数的this锁。
		 * 2.进入sale()方法后要拿到obj锁才能进入同步代码块。
		 */
		else {
			while (true) {
				sale();
			}
		}
	}

	public synchronized void sale() { //同步函数使用this锁
			synchronized (obj) {
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
