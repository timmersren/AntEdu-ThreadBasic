package cn.rain.thread.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * description: 需求：要求t1,t2两个线程执行完成后，主线程才能继续执行。
 * @author 任伟
 * @date Mar 12, 2018
 */
public class CountDownMain {
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch countDownLatch = new CountDownLatch(2); //有两条自定义线程，故让计数器初始数值为2
		CountThread1 thread1 = new CountThread1(countDownLatch);
		CountThread1 thread2 = new CountThread1(countDownLatch);
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		
		t1.start();
		t2.start();
		
		/*
		 * 这里调用CountDownLatch的await方法，意思是如果此时计数器的数值大于0，
		 * 那么该线程的程序（这里是主线程）到这里会阻塞住，直到小于等于0才能继续。
		 * 这样就控制了主线程执行到这里阻塞住，直到其他两条线程执行完毕后，
		 * 并且其他线程每次执行完毕后都会将计数器-1，因此只有当t1,t2全都执行完以后，
		 * 计数器数值才能为0，这里的await阻塞才会放行使得主线程继续向下执行。
		 * 
		 * 如果将计数器初始数值置为3，那么执行到次，计数器数值为1，便会一直阻塞住。
		 * 如果将计数器初始数值置为1，那么当有一个线程执行完毕后，数值就为0了，
		 * 那么主线程就不再会在这里阻塞，它将会和另一条没有执行完的线程抢夺CPU资源进行执行。
		 * */
		countDownLatch.await();
		
		System.out.println("主线程继续执行...");
		for (int i = 0; i < 10; i++) {
			System.out.println("主线程 循环第" + (i + 1) + "次");
		}
		System.out.println("主线程执行完毕...");
	}
}
