package cn.rain.thread;

/**
 * 线程的创建方式2：通过实现Runable接口
 * @author admin
 */
public class ThreadDemo2{
	public static void main(String[] args) {
		MyThread2 myThread2 = new MyThread2();
		Thread t1 = new Thread(myThread2);
		t1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main run: " + i);
		}
	}
}
