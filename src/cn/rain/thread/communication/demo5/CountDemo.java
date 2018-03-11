package cn.rain.thread.communication.demo5;

/**
 * description: 这里演示一个例子，我们对count进行3次循环的+1操作，
 * 我们知道，三条线程如果同时对这个共享数据count进行操作并且不进行线程同步的话，
 * 势必会引起线程安全问题，这不是我们在这个例子中关心的。
 * 我们现在的需求是这样的：每条线程都进行自己的+1操作，循环三次，且不和其他线程共享
 * count变量，也就是说我们希望每条线程得到的结果都是 1,2,3
 * 我们当然可以new三个CountDemo的对象，然后分别放入每个线程中，但是我们要求只能new一个对象，
 * 要解决这个需求，就要用到ThreadLocal了。
 * 
 * @author 任伟
 * @date Mar 11, 2018
 */
public class CountDemo implements Runnable {
	
	private int count = 0;
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			count++;
			System.out.println(Thread.currentThread().getName() + "-- count:" + count);
		}
	}
}
