package cn.rain.thread;

/**
 * 线程的创建方式1：通过继承Thread类创建线程
 * @author admin
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		
		MyThread1 t1 = new MyThread1();
		t1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main run: " + i);
		}
	}
}
